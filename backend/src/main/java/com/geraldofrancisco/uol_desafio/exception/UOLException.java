package com.geraldofrancisco.uol_desafio.exception;

import com.geraldofrancisco.uol_desafio.domain.enums.ExceptionType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UOLException extends RuntimeException {
    private ExceptionType exception;
}
