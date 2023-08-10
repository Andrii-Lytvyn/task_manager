package de.ait.taskmanager.validation.constrains;

import de.ait.taskmanager.validation.validator.StartBeforeFinishValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StartBeforeFinishValidator.class)

public @interface StartBeforeFinishDate {
    String message() default "Finish date can't be earlier than start date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
