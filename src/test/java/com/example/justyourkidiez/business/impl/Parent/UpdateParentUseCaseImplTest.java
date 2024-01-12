package com.example.justyourkidiez.business.impl.Parent;

import com.example.justyourkidiez.business.exception.InvalidParentException;
import com.example.justyourkidiez.business.exception.UnauthorizedDataAccessException;
import com.example.justyourkidiez.domain.AccessToken;
import com.example.justyourkidiez.domain.Parent.UpdateParentRequest;
import com.example.justyourkidiez.persistence.ParentRepository;
import com.example.justyourkidiez.persistence.entity.ParentEntity;
import com.example.justyourkidiez.persistence.entity.User.RoleEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateParentUseCaseImplTest {
    @Mock
    private ParentRepository parentRepository;

    @InjectMocks
    private UpdateParentUseCaseImpl updateParentUseCase;

    @Test
    void updateParent() {
        UpdateParentRequest request = new UpdateParentRequest();
        request.setId(1L);
        request.setName("John");
        request.setCourseId(123L);

        when(parentRepository.findById(request.getId())).thenReturn(Optional.empty());

                assertThrows(InvalidParentException.class, () -> updateParentUseCase.updateParent(request));
    }

}
