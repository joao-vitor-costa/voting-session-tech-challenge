package com.joao.core.exception;

import lombok.Getter;

public class BadRequestException extends RuntimeException {
    @Getter
    private final String errorCode;

    public BadRequestException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
