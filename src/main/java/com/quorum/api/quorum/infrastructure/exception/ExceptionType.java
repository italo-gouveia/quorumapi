package com.quorum.api.quorum.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionType {
    UNMAPPED_ERROR(0, "Unmapped Error!"),
    FIELD_VALIDATOR_ERROR(1, "Field Validation error");

    private final Integer id;
    private final String message;

}
