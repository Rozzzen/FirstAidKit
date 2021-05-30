package com.zhuk.exception.exceptions;

public class BandageNotFoundException extends RuntimeException {
    public BandageNotFoundException(String message) {
        super(message);
    }
}