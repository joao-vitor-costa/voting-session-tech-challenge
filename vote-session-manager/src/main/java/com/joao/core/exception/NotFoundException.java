package com.joao.core.exception;

import com.joao.core.enumeration.ExceptionCodeEnumeration;
import lombok.Getter;

public class NotFoundException extends RuntimeException {
    @Getter
    private final String errorCode;

    public NotFoundException(ExceptionCodeEnumeration exceptionCodeEnumeration) {
        super(exceptionCodeEnumeration.message);
        this.errorCode = exceptionCodeEnumeration.name();
    }

    public NotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
