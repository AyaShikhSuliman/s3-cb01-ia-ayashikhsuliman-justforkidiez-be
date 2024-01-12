package com.example.justyourkidiez.business.UseCases;

import com.example.justyourkidiez.domain.LoginRequest;
import com.example.justyourkidiez.domain.LoginResponse;

public interface LoginUseCase {
    LoginResponse login(LoginRequest loginRequest);
}
