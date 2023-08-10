package de.ait.taskmanager.validation.handler;

import de.ait.taskmanager.validation.dto.TaskDayAfterTodayErrorDro;
import de.ait.taskmanager.validation.dto.TaskDayAfterTodayErrorsDro;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;
@ControllerAdvice
public class TaskDayAfterTodayHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<TaskDayAfterTodayErrorsDro> handleException(MethodArgumentNotValidException e) {
        // собираем список всех ошибок в JSON-виде
        List<TaskDayAfterTodayErrorDro> validationErrors = e.getBindingResult().getAllErrors().stream() // пробегаем все ошибки с помощью stream
                .filter(error -> error instanceof ObjectError) // выбрали только FieldError
                .map(error -> (ObjectError) error) // сделали преобразование
                .map(error -> { // собираем информацию об ошибке в формате JSON
                    TaskDayAfterTodayErrorDro errorDto = TaskDayAfterTodayErrorDro.builder()
                            .field(error.getObjectName())
                            .message(error.getDefaultMessage())
                            .build();

                    if (error.getArguments() != null) { // если пользователь ввел значение, которое не нравится валидатору
                        errorDto.setRejectedValue(error.getArguments().toString()); // то добавим это значение в ответ
                    }

                    return errorDto;
                })
                .collect(Collectors.toList());

        return ResponseEntity // отправляем
                .badRequest()
                .body(TaskDayAfterTodayErrorsDro.builder()
                        .errors(validationErrors)
                        .build());
    }
}
