package com.example.justyourkidiez.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidCourseException extends ResponseStatusException {
    public InvalidCourseException() {
        super(HttpStatus.BAD_REQUEST, "COURSE_INVALID");
    }
}
