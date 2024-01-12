package com.example.justyourkidiez.business.UseCases.Parent;

import com.example.justyourkidiez.domain.Parent.Parent;

import java.util.Optional;

public interface GetParentUseCase {
    Optional<Parent> getParent(long parentId);
}
