package com.example.justyourkidiez.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidParentException extends ResponseStatusException {
    public InvalidParentException(String errorCode) {
        super(HttpStatus.BAD_REQUEST, errorCode);
    }
}
