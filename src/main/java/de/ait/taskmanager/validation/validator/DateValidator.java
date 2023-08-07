package de.ait.taskmanager.validation.validator;

import de.ait.taskmanager.validation.constrains.BeforeCurrentDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;


public class DateValidator implements ConstraintValidator<BeforeCurrentDate, LocalDate> {

    private static final LocalDate dateToday = LocalDate.now();


    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext constraintValidatorContext) {

       return !date.isBefore(dateToday);

    }
}
