package com.geraldofrancisco.uol_desafio.rest.validate.impl;

import com.geraldofrancisco.uol_desafio.rest.validate.ValueOfEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class ValueOfEnumImpl implements ConstraintValidator<ValueOfEnum, String> {
    List<String> values;

    @Override
    public void initialize(ValueOfEnum constraint) {
        this.values = Arrays.stream(constraint.enumClass().getEnumConstants())
                .map(Enum::name)
                .toList();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.isBlank(value) || this.values.stream().anyMatch(s -> s.equals(value));
    }
}
