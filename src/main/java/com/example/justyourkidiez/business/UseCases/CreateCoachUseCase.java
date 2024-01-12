package com.example.justyourkidiez.business.UseCases;

import com.example.justyourkidiez.domain.Coach.CreateCoachRequest;
import com.example.justyourkidiez.domain.Coach.CreateCoachResponse;

public interface CreateCoachUseCase {
    CreateCoachResponse createCoach(CreateCoachRequest request);
}
