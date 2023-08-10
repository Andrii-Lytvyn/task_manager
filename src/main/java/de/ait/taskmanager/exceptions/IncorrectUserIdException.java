package de.ait.taskmanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class IncorrectUserIdException extends RestException {

    public IncorrectUserIdException(Long incorrectId) {
        super(HttpStatus.UNPROCESSABLE_ENTITY, "Id of user <" + incorrectId + "> is incorrect.");
    }
}
