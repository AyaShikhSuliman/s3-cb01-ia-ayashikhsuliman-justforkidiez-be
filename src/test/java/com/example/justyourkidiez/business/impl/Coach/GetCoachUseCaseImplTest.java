package com.example.justyourkidiez.business.impl.Coach;

import com.example.justyourkidiez.business.exception.UnauthorizedDataAccessException;
import com.example.justyourkidiez.domain.AccessToken;
import com.example.justyourkidiez.domain.Coach.Coach;
import com.example.justyourkidiez.persistence.CoachRepository;
import com.example.justyourkidiez.persistence.entity.CoachEntity;
import com.example.justyourkidiez.persistence.entity.User.RoleEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetCoachUseCaseImplTest {
    @Mock
    private CoachRepository coachRepository;
    @Mock
    private AccessToken requestAccessToken;

    @InjectMocks
    private GetCoachUseCaseImpl getCoachUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        getCoachUseCase = new GetCoachUseCaseImpl(coachRepository, requestAccessToken);
    }

    @Test
    public void لetCoachWithValidCoachId() {
        long coachId = 1;
        CoachEntity coachEntity = new CoachEntity();
        coachEntity.setId(coachId);
        when(requestAccessToken.hasRole(RoleEnum.COACH.name())).thenReturn(true);
        when(coachRepository.findById(coachId)).thenReturn(Optional.of(coachEntity));

        Optional<Coach> result = getCoachUseCase.getCoach(coachId);

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(coachId, result.get().getId());

        verify(requestAccessToken, times(1)).hasRole(RoleEnum.COACH.name());
        verify(coachRepository, times(1)).findById(coachId);
    }

    @Test
    public void getCoachWithUnauthorizedAccess() {
        long coachId = 2;
        when(requestAccessToken.hasRole(RoleEnum.COACH.name())).thenReturn(false);
        when(requestAccessToken.getCoachId()).thenReturn(3L);

        Assertions.assertThrows(
                UnauthorizedDataAccessException.class,
                () -> getCoachUseCase.getCoach(coachId),
                "COACH_ID_NOT_FROM_LOGGED_IN_USER"
        );

        verify(requestAccessToken, times(1)).hasRole(RoleEnum.COACH.name());
        verify(requestAccessToken, times(1)).getCoachId();
        verifyNoMoreInteractions(coachRepository);
    }

    @Test
    public void getCoachWithNonExistentCoachId() {
        long coachId = 4;
        when(requestAccessToken.hasRole(RoleEnum.COACH.name())).thenReturn(true);
        when(coachRepository.findById(coachId)).thenReturn(Optional.empty());

        Optional<Coach> result = getCoachUseCase.getCoach(coachId);

        Assertions.assertFalse(result.isPresent());

        verify(requestAccessToken, times(1)).hasRole(RoleEnum.COACH.name());
        verify(coachRepository, times(1)).findById(coachId);
    }
}

