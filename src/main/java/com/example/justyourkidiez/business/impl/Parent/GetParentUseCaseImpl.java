package com.example.justyourkidiez.business.impl.Parent;

import com.example.justyourkidiez.business.UseCases.Parent.GetParentUseCase;
import com.example.justyourkidiez.business.exception.UnauthorizedDataAccessException;
import com.example.justyourkidiez.domain.AccessToken;
import com.example.justyourkidiez.domain.Parent.Parent;
import com.example.justyourkidiez.persistence.ParentRepository;
import com.example.justyourkidiez.persistence.entity.User.RoleEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetParentUseCaseImpl implements GetParentUseCase {
    private ParentRepository parentRepository;
    private AccessToken requestAccessToken;


    @Override
    public Optional<Parent> getParent(long parentId) {
        if (!requestAccessToken.hasRole(RoleEnum.PARENT.name())) {
            if (requestAccessToken.getParentId() != parentId) {
                throw new UnauthorizedDataAccessException("PARENT_ID_NOT_FROM_LOGGED_IN_USER");
            }
        }

        return parentRepository.findById(parentId).map(ParentConverter::convert);    }
}
