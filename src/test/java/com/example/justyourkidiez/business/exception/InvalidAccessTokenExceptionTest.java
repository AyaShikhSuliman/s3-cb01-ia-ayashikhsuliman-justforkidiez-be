package com.example.justyourkidiez.business.exception;

import com.example.justyourkidiez.business.exception.InvalidAccessTokenException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@ExtendWith(MockitoExtension.class)
public class InvalidAccessTokenExceptionTest {
    @Test
    public void constructor() {
        String errorCause = "Invalid access token";

        InvalidAccessTokenException exception = new InvalidAccessTokenException(errorCause);

        Assertions.assertEquals(HttpStatus.UNAUTHORIZED, exception.getStatus());
        Assertions.assertEquals(errorCause, exception.getReason());
    }
}

