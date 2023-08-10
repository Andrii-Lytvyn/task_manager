package de.ait.taskmanager.validation.validator;


import de.ait.taskmanager.validation.constrains.TaskDayAfterToday;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;




public class TaskDayAfterTodayValidator implements ConstraintValidator<TaskDayAfterToday, LocalDate> {

    private static final LocalDate dateToday = LocalDate.now();


    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext constraintValidatorContext) {

        return !date.isBefore(dateToday);

    }
}