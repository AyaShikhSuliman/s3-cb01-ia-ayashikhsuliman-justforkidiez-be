package com.example.justyourkidiez.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidLessonException extends ResponseStatusException {
    public InvalidLessonException() {
        super(HttpStatus.BAD_REQUEST, "LESSON_INVALID");
    }
}
