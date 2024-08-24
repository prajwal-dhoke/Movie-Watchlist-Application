package com.example.watchlist.watchlistapplication.entity.Validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ratingAnnotationLogic.class)
public @interface Rating {
    String message() default "Invalid Rating Please please give 0 - 5";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
