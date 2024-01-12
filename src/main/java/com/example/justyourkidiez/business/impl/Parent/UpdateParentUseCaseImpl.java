package com.example.justyourkidiez.business.impl.Parent;

import com.example.justyourkidiez.business.UseCases.Parent.UpdateParentUseCase;
import com.example.justyourkidiez.business.exception.InvalidParentException;
import com.example.justyourkidiez.business.exception.UnauthorizedDataAccessException;
import com.example.justyourkidiez.domain.AccessToken;
import com.example.justyourkidiez.domain.Parent.UpdateParentRequest;
import com.example.justyourkidiez.persistence.ParentRepository;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import com.example.justyourkidiez.persistence.entity.ParentEntity;
import com.example.justyourkidiez.persistence.entity.User.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateParentUseCaseImpl implements UpdateParentUseCase {
    private final ParentRepository parentRepository;
    private AccessToken requestAccessToken;

    @Transactional
    @Override
    public void updateParent(UpdateParentRequest request) {
        Optional<ParentEntity> parentOptional = parentRepository.findById(request.getId());
        if (parentOptional.isEmpty()) {
            throw new InvalidParentException("COACH_ID_INVALID");
        }

        if (!requestAccessToken.hasRole(RoleEnum.PARENT.name())) {
            if (requestAccessToken.getParentId() != request.getId()) {
                throw new UnauthorizedDataAccessException("PARENT_ID_NOT_FROM_LOGGED_IN_USER");
            }
        }

        ParentEntity parent = parentOptional.get();
        updateFields(request, parent);
    }

    private void updateFields(UpdateParentRequest request, ParentEntity parent) {
        parent.setName(request.getName());
        parent.setCourse(CourseEntity.builder().id(request.getCourseId()).build());

        parentRepository.save(parent);
    }
}
