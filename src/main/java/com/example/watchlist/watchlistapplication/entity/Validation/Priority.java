package com.example.watchlist.watchlistapplication.entity.Validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = priorityAnnotationLogic.class)
public @interface Priority {
    String message() default "Invalid Priority Please enter L|M|H";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
