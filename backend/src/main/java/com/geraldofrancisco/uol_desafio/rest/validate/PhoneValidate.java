package com.geraldofrancisco.uol_desafio.rest.validate;

import com.geraldofrancisco.uol_desafio.rest.validate.impl.PhoneValidateImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PhoneValidateImpl.class)
@Retention(RUNTIME)
@Target({PARAMETER, FIELD})
@ReportAsSingleViolation
public @interface PhoneValidate {
    String message() default "PHONE_INVALID";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
