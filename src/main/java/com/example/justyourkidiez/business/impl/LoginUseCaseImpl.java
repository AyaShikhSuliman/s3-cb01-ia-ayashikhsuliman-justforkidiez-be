package com.example.justyourkidiez.business.impl;

import com.example.justyourkidiez.business.UseCases.AccessTokenEncoder;
import com.example.justyourkidiez.business.exception.InvalidCredentialsException;
import com.example.justyourkidiez.business.UseCases.LoginUseCase;
import com.example.justyourkidiez.domain.AccessToken;
import com.example.justyourkidiez.domain.LoginRequest;
import com.example.justyourkidiez.domain.LoginResponse;
import com.example.justyourkidiez.persistence.UserRepository;
import com.example.justyourkidiez.persistence.entity.User.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AccessTokenEncoder accessTokenEncoder;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        UserEntity user = userRepository.findByUsername(loginRequest.getUsername());
        if (user == null) {
            throw new InvalidCredentialsException();
        }

        if (!matchesPassword(loginRequest.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }

        String accessToken = generateAccessToken(user);
        return LoginResponse.builder().accessToken(accessToken).build();
    }

    private boolean matchesPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    private String generateAccessToken(UserEntity user) {
        Long parentId = user.getParent() != null ? user.getParent().getId() : null;
        List<String> roles = user.getUserRoles().stream().map(userRole -> userRole.getRole().toString()).toList();

        return accessTokenEncoder.encode(AccessToken.builder().subject(user.getUsername()).roles(roles).parentId(parentId).build());
    }
}
