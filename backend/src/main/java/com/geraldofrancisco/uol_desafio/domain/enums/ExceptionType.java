package com.geraldofrancisco.uol_desafio.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Getter
@AllArgsConstructor
public enum ExceptionType {

    GENERIC(INTERNAL_SERVER_ERROR, "500.001"),
    NO_VACANCY_FOR_THE_TYPE(UNPROCESSABLE_ENTITY, "422.001"),
    USER_ALREADY_REGISTERED_FOR_THE_TYPE(UNPROCESSABLE_ENTITY, "422.002");

    private final HttpStatus status;
    private final String code;
}
