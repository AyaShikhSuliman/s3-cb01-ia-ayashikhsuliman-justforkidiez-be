package com.example.justyourkidiez.business.impl.Coach;

import com.example.justyourkidiez.business.UseCases.Coach.GetCoachUseCase;
import com.example.justyourkidiez.business.exception.UnauthorizedDataAccessException;
import com.example.justyourkidiez.business.impl.Parent.ParentConverter;
import com.example.justyourkidiez.domain.AccessToken;
import com.example.justyourkidiez.domain.Coach.Coach;
import com.example.justyourkidiez.persistence.CoachRepository;
import com.example.justyourkidiez.persistence.entity.User.RoleEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetCoachUseCaseImpl implements GetCoachUseCase {
    private CoachRepository coachRepository;
    private AccessToken requestAccessToken;
    @Override
    public Optional<Coach> getCoach(long coachId) {
        if (!requestAccessToken.hasRole(RoleEnum.COACH.name())) {
            if (requestAccessToken.getCoachId() != coachId) {
                throw new UnauthorizedDataAccessException("COACH_ID_NOT_FROM_LOGGED_IN_USER");
            }
        }

        return coachRepository.findById(coachId).map(CoachConverter::convert);    }
}
