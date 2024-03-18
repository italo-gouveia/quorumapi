package com.quorum.api.quorum.infrastructure.exception;


public class FieldValidatorException extends APIException {
    public FieldValidatorException(String message) {
        this(ExceptionType.FIELD_VALIDATOR_ERROR, message);
    }

    public FieldValidatorException(ExceptionType type, String message){
        super(type, message);
    }
}
