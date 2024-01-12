package com.example.justyourkidiez.business.UseCases.Coach;

import com.example.justyourkidiez.domain.Coach.Coach;

import java.util.Optional;

public interface GetCoachUseCase {
    Optional<Coach> getCoach(long coachId);

}
