package com.geraldofrancisco.uol_desafio.exception;

import com.geraldofrancisco.uol_desafio.domain.enums.ExceptionType;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static com.geraldofrancisco.uol_desafio.domain.enums.ExceptionType.BAD_REQUEST_ERROR;
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
                .doFirst(() -> log.error("Aconteceu um erro genérico ", ex));
    }

    @ExceptionHandler(UOLException.class)
    public Mono<ResponseEntity<ExceptionResponse>> handlerException (final UOLException ex) {
        return Mono.just(ex.getException())
                .flatMap(type -> getExceptionResponse(type, null, null))
                .doFirst(() -> log.error("Aconteceu um erro esperado pelo sistema. Cod: {}", ex.getException().getCode()));
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public Mono<ResponseEntity<ExceptionResponse>> handlerException(final WebExchangeBindException ex) {
        return Flux.fromIterable(ex.getFieldErrors())
                .map(e -> ErrorFieldResponse.builder()
                        .name(e.getField())
                        .message(getMessage(e.getDefaultMessage()))
                        .build()
                )
                .collectList()
                .flatMap(list -> getExceptionResponse(BAD_REQUEST_ERROR, null, list))
                .doFirst(() -> log.error("Aconteceu um erro de validação de campos de requisição: ", ex));

    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Mono<ResponseEntity<ExceptionResponse>> handlerException (final ConstraintViolationException ex) {
        return Flux.fromIterable(ex.getConstraintViolations())
                .map(e -> ErrorFieldResponse.builder()
                        .name(((PathImpl)e.getPropertyPath()).getLeafNode().getName())
                        .message(getMessage(e.getMessageTemplate()))
                        .build()
                )
                .collectList()
                .flatMap(list -> getExceptionResponse(BAD_REQUEST_ERROR, null, list))
                .doFirst(() -> log.error("Aconteceu um erro de validação de campos de requisição: ", ex));
    }

    private Mono<ResponseEntity<ExceptionResponse>> getExceptionResponse
            (final ExceptionType type, final String message, final List<ErrorFieldResponse> fields) {
    return Mono.just(ExceptionResponse.builder()
            .fields(fields)
            .errorMessage(fillErrorMessage(message, type))
            .errorCode(type.getCode())
            .build()
        )
        .map(response -> ResponseEntity.status(type.getStatus()).body(response));
    }

    private String fillErrorMessage(String message, ExceptionType type) {
        if(StringUtils.isNotBlank(message))
            return message;
        if(Objects.nonNull(type.getCode()))
            return getMessage(type.getCode());
        return null;
    }

    private String getMessage(String error) {
        return messageSource.getMessage(error, null, Locale.getDefault());
    }
}

