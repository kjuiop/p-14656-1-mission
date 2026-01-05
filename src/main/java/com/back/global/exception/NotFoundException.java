package com.back.global.exception;

/**
 * @author : JAKE
 * @date : 26. 1. 5.
 */
public class NotFoundException extends DomainException {

    public NotFoundException(String message) {
        super("404", message);
    }
}
