package com.zhuk.exception.exceptions;

public class GlovesNotFoundException extends RuntimeException {
    public GlovesNotFoundException(String message) {
        super(message);
    }
}