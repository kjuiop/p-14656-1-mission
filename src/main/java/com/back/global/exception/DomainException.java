package com.back.global.exception;

/**
 * @author : JAKE
 * @date : 26. 1. 5.
 */
public class DomainException extends RuntimeException {
    String resultCode;

    public DomainException(String resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }
}
