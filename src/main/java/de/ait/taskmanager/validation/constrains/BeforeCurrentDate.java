package de.ait.taskmanager.validation.constrains;

import de.ait.taskmanager.validation.validator.DateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidator.class)

public @interface BeforeCurrentDate {
    String message() default "Date can't be earlier than today";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
