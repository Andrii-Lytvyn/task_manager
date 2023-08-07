package de.ait.taskmanager.validation.handler;

import de.ait.taskmanager.validation.dto.BeforeCurrentDataErrorsDto;
import de.ait.taskmanager.validation.dto.BeforeCurrentDateErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

public class ValidationExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BeforeCurrentDataErrorsDto> handleException(MethodArgumentNotValidException e) {
        // собираем список всех ошибок в JSON-виде
        List<BeforeCurrentDateErrorDto> validationErrors = e.getBindingResult().getAllErrors().stream() // пробегаем все ошибки с помощью stream
                .filter(error -> error instanceof FieldError) // выбрали только FieldError
                .map(error -> (FieldError) error) // сделали преобразование
                .map(error -> { // собираем информацию об ошибке в формате JSON
                    BeforeCurrentDateErrorDto errorDto = BeforeCurrentDateErrorDto.builder()
                            .field(error.getField())
                            .message(error.getDefaultMessage())
                            .build();

                    if (error.getRejectedValue() != null) { // если пользователь ввел значение, которое не нравится валидатору
                        errorDto.setRejectedValue(error.getRejectedValue().toString()); // то добавим это значение в ответ
                    }

                    return errorDto;
                })
                .collect(Collectors.toList());

        return ResponseEntity // отправляем
                .badRequest()
                .body(BeforeCurrentDataErrorsDto.builder()
                        .errors(validationErrors)
                        .build());
    }
}
