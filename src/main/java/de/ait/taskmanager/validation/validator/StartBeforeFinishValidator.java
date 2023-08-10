package de.ait.taskmanager.validation.validator;

import de.ait.taskmanager.dto.NewTaskDto;
import de.ait.taskmanager.validation.constrains.StartBeforeFinishDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartBeforeFinishValidator implements ConstraintValidator<StartBeforeFinishDate, NewTaskDto> {


    @Override
    public boolean isValid(NewTaskDto taskDto, ConstraintValidatorContext constraintValidatorContext) {

        return taskDto.getFinishDate().isAfter(taskDto.getStartDate());

    }
}
