package com.deke.testredisdbjpa.validation;


import com.deke.testredisdbjpa.constants.messageConstants.ValidationMessages;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {UniqueHotelNameValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueHotelName {

    String message() default ValidationMessages.UNIQUE_HOTEL_NAME;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
