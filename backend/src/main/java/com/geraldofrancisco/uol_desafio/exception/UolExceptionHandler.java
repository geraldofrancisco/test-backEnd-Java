package com.geraldofrancisco.uol_desafio.exception;

import com.geraldofrancisco.uol_desafio.domain.enums.ExceptionType;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Locale;

import static com.geraldofrancisco.uol_desafio.domain.enums.ExceptionType.GENERIC;

@Slf4j
@Hidden
@AllArgsConstructor
@RestControllerAdvice
public class UolExceptionHandler {
    private MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<ExceptionResponse>> handlerException (final Exception ex) {
        return Mono.just(GENERIC)
                .flatMap(type -> getExceptionResponse(type, ex.getMessage(), null))
                .doFirst(() -> log.error("There was a generic error: ", ex));
    }

    private Mono<ResponseEntity<ExceptionResponse>> getExceptionResponse
            (final ExceptionType type, final String message, final List<ErrorFieldResponse> fields) {
    return Mono.just(ExceptionResponse.builder()
            .fields(fields)
            .errorMessage(StringUtils.isNotBlank(message) ? message : getMessage(type.getCode()))
            .errorCode(type.getCode())
            .build()
        )
        .map(response -> ResponseEntity.status(type.getStatus()).body(response));
    }

    private String getMessage(String error) {
        return messageSource.getMessage(error, null, Locale.getDefault());
    }
}

