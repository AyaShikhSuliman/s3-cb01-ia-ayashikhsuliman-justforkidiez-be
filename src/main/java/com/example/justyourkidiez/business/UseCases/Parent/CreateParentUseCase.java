package com.example.justyourkidiez.business.UseCases.Parent;

import com.example.justyourkidiez.domain.Parent.CreateParentRequest;
import com.example.justyourkidiez.domain.Parent.CreateParentResponse;

public interface CreateParentUseCase {
    CreateParentResponse createParent(CreateParentRequest request);
}
