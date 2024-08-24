package com.example.watchlist.watchlistapplication.entity.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ratingAnnotationLogic implements ConstraintValidator< Rating, Float>{

    @Override
    public boolean isValid(Float value, ConstraintValidatorContext context) {

        return value >= 0 && value <= 10;
    }

}
