package com.deke.testredisdbjpa.validation;


import com.deke.testredisdbjpa.utils.messages.ValidationMessages;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {UniqueNameValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueCustomerName {

    String message() default ValidationMessages.UNIQUE_NAME;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
