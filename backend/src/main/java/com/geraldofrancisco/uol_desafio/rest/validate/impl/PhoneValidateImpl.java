package com.geraldofrancisco.uol_desafio.rest.validate.impl;

import com.geraldofrancisco.uol_desafio.rest.validate.PhoneValidate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class PhoneValidateImpl implements ConstraintValidator<PhoneValidate, String> {
  @Override
  public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
    var p = Pattern.compile("^\\(?\\d{2}\\)?[\\s-]?\\d{4,5}-?\\d{4}$");

    return StringUtils.isBlank(phone) || p.matcher(phone).matches();
  }
}
