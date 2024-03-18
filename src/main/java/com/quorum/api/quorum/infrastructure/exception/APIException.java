package com.quorum.api.quorum.infrastructure.exception;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public abstract class APIException extends RuntimeException {
    private final ExceptionType type;

    public APIException(ExceptionType type) {
        this(type, StringUtils.EMPTY);
    }

    public APIException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

}
