package com.example.justyourkidiez.business.impl.Coach;

import com.example.justyourkidiez.domain.Coach.CreateCoachRequest;
import com.example.justyourkidiez.domain.Coach.CreateCoachResponse;
import com.example.justyourkidiez.persistence.CoachRepository;
import com.example.justyourkidiez.persistence.UserRepository;
import com.example.justyourkidiez.persistence.entity.CoachEntity;
import com.example.justyourkidiez.persistence.entity.User.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateCoachUseCaseImplTest {

    @InjectMocks
    private CreateCoachUseCaseImpl createCoachUseCase;

    @Mock
    private CoachRepository coachRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    public void createCoach() {
        CreateCoachRequest request = new CreateCoachRequest("John", "Doe", 30L, "1234567890", "john.doe@example.com", "password");

        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");

        CoachEntity savedCoach = new CoachEntity();
        savedCoach.setId(1L);
        when(coachRepository.save(any(CoachEntity.class))).thenReturn(savedCoach);

        CreateCoachResponse response = createCoachUseCase.createCoach(request);

        verify(passwordEncoder, times(1)).encode("password");
        verify(coachRepository, times(1)).save(any(CoachEntity.class));
        verify(userRepository, times(1)).save(any(UserEntity.class));

        assertNotNull(response);
        assertEquals(1L, response.getCoachId());
    }
}
