package com.example.watchlist.watchlistapplication.entity.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class priorityAnnotationLogic implements ConstraintValidator< Priority, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return value.trim().length() == 1 && "LMH".contains(value.trim());
    }

}
