package com.example.justyourkidiez.business.UseCases.Parent;

import com.example.justyourkidiez.domain.Parent.GetAllParentsRequest;
import com.example.justyourkidiez.domain.Parent.GetAllParentsResponse;

public interface GetParentsUseCase {
    GetAllParentsResponse getParents();
}
