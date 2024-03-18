package com.quorum.api.quorum.entrypoint.rest.handler;


import com.quorum.api.quorum.infrastructure.exception.ExceptionModel;
import com.quorum.api.quorum.infrastructure.exception.ExceptionType;
import com.quorum.api.quorum.infrastructure.exception.FieldValidatorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionRestControlHandler {

    private static final String M_HANDLE_ERROR_TYP_MESSAGE = "M=handle, error_typ={}, message={}";

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ExceptionModel> handle(Throwable e) {
        ExceptionType type = ExceptionType.UNMAPPED_ERROR;
        //TODO: solve problem compiling slf4j
        //log.error(M_HANDLE_ERROR_TYP_MESSAGE, type.name(), e.getMessage(), e);
        return transcode(
                HttpStatus.INTERNAL_SERVER_ERROR,
                type,
                e
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionModel> handle(MethodArgumentNotValidException e) {
        ExceptionType type = ExceptionType.FIELD_VALIDATOR_ERROR;
        //TODO: solve problem compiling slf4j
        //log.error(M_HANDLE_ERROR_TYP_MESSAGE, type.name(), e.getMessage(), e);
        return transcode(
                HttpStatus.BAD_REQUEST,
                type,
                e
        );
    }

    @ExceptionHandler(FieldValidatorException.class)
    public ResponseEntity<ExceptionModel> handle(FieldValidatorException e) {
        ExceptionType type = ExceptionType.FIELD_VALIDATOR_ERROR;
        //TODO: solve problem compiling slf4j
        //log.error(M_HANDLE_ERROR_TYP_MESSAGE, type.name(), e.getMessage(), e);
        return transcode(HttpStatus.BAD_REQUEST, type, e);
    }


    private ResponseEntity<ExceptionModel> transcode(HttpStatus status, ExceptionType type, Throwable exception) {
        return ResponseEntity
                .status(status)
                .body(ExceptionModel.of(type.getId(), type.getMessage(), exception.getMessage()));

    }
}
