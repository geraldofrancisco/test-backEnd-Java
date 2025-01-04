package com.geraldofrancisco.uol_desafio.rest.validate;

import com.geraldofrancisco.uol_desafio.rest.validate.impl.PhoneValidateImpl;
import com.geraldofrancisco.uol_desafio.rest.validate.impl.ValueOfEnumImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = ValueOfEnumImpl.class)
@Retention(RUNTIME)
@Target({PARAMETER, FIELD})
public @interface ValueOfEnum  {
    Class<? extends Enum> enumClass();
    String message() default "Value is not valid";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
