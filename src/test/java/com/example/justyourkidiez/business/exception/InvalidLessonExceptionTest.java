package com.example.justyourkidiez.business.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@ExtendWith(MockitoExtension.class)
public class InvalidLessonExceptionTest {
    @Test
    public void constructor() {
        InvalidLessonException exception = new InvalidLessonException();

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
        Assertions.assertEquals("LESSON_INVALID", exception.getReason());
    }
}
