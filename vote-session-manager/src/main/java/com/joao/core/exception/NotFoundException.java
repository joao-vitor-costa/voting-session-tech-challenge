package com.joao.core.exception;

import com.joao.core.enumeration.ExceptionCode;
import lombok.Getter;

public class NotFoundException extends RuntimeException {
    @Getter
    private final String errorCode;

    public NotFoundException(ExceptionCode exceptionCode) {
        super(exceptionCode.message);
        this.errorCode = exceptionCode.name();
    }
}
