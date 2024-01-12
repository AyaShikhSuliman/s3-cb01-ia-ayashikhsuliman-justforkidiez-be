package com.example.justyourkidiez.business.impl;

import com.example.justyourkidiez.business.UseCases.AccessTokenEncoder;
import com.example.justyourkidiez.business.exception.InvalidCredentialsException;
import com.example.justyourkidiez.domain.AccessToken;
import com.example.justyourkidiez.domain.LoginRequest;
import com.example.justyourkidiez.domain.LoginResponse;
import com.example.justyourkidiez.persistence.UserRepository;
import com.example.justyourkidiez.persistence.entity.User.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Assertions;

@ExtendWith(MockitoExtension.class)
public class LoginUseCaseImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private AccessTokenEncoder accessTokenEncoder;

    @InjectMocks
    private LoginUseCaseImpl loginUseCase;

    @Test
    public void login() {
        LoginRequest loginRequest = new LoginRequest("username", "password");
        when(userRepository.findByUsername(loginRequest.getUsername())).thenReturn(null);

        Assertions.assertThrows(
                InvalidCredentialsException.class,
                () -> loginUseCase.login(loginRequest),
                "Invalid credentials"
        );

        verify(userRepository, times(1)).findByUsername(loginRequest.getUsername());
        verifyNoMoreInteractions(passwordEncoder, accessTokenEncoder);
    }

    @Test
    public void loginWithWrongPassword() {
        LoginRequest loginRequest = new LoginRequest("username", "password");
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("username");
        userEntity.setPassword("encodedPassword");
        when(userRepository.findByUsername(loginRequest.getUsername())).thenReturn(userEntity);
        when(passwordEncoder.matches(loginRequest.getPassword(), userEntity.getPassword())).thenReturn(false);

        Assertions.assertThrows(
                InvalidCredentialsException.class,
                () -> loginUseCase.login(loginRequest),
                "Invalid credentials"
        );

        verify(userRepository, times(1)).findByUsername(loginRequest.getUsername());
        verify(passwordEncoder, times(1)).matches(loginRequest.getPassword(), userEntity.getPassword());
        verifyNoMoreInteractions(accessTokenEncoder);
    }
}
