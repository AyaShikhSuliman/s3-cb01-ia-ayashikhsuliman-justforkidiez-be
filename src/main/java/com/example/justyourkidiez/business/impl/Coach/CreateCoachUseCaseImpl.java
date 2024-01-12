package com.example.justyourkidiez.business.impl.Coach;

import com.example.justyourkidiez.business.UseCases.CreateCoachUseCase;
import com.example.justyourkidiez.domain.Coach.CreateCoachRequest;
import com.example.justyourkidiez.domain.Coach.CreateCoachResponse;
import com.example.justyourkidiez.persistence.CoachRepository;
import com.example.justyourkidiez.persistence.UserRepository;
import com.example.justyourkidiez.persistence.entity.*;
import com.example.justyourkidiez.persistence.entity.User.RoleEnum;
import com.example.justyourkidiez.persistence.entity.User.UserEntity;
import com.example.justyourkidiez.persistence.entity.User.UserRoleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CreateCoachUseCaseImpl implements CreateCoachUseCase {
    private static final String USERNAME_SUFFIX = "@justyourkidiez.nl";
    private final CoachRepository coachRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public CreateCoachResponse createCoach(CreateCoachRequest request) {
        CoachEntity savedCoach = saveNewCoach(request);

        saveNewUser(savedCoach, request.getPassword());

        return CreateCoachResponse.builder()
                .coachId(savedCoach.getId())
                .build();
    }

    private void saveNewUser(CoachEntity coach, String password) {
        String encodedPassword = passwordEncoder.encode(password);

        UserEntity newUser = UserEntity.builder()
                .username(coach.getName() + USERNAME_SUFFIX)
                .password(encodedPassword)
                .coach(coach)
                .build();

        newUser.setUserRoles(Set.of(
                UserRoleEntity.builder()
                        .user(newUser)
                        .role(RoleEnum.COACH)
                        .build()));
        userRepository.save(newUser);
    }

    private CoachEntity saveNewCoach(CreateCoachRequest request) {
        CoachEntity newCoach = CoachEntity.builder()
                .name(request.getName())
                .last_name(request.getLast_name())
                .age(request.getAge())
                .phone_number(request.getPhone_number())
                .email_address(request.getEmail_address())
                .build();
        return coachRepository.save(newCoach);
    }
}
