package com.quorum.api.quorum.entrypoint.rest.exception;

import com.quorum.api.quorum.infrastructure.exception.FieldValidatorException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(FieldValidatorException.class)
    protected ResponseEntity<String> handleFieldValidatorException(FieldValidatorException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
