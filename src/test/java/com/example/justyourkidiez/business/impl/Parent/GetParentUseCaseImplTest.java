package com.example.justyourkidiez.business.impl.Parent;

import com.example.justyourkidiez.business.exception.UnauthorizedDataAccessException;
import com.example.justyourkidiez.domain.AccessToken;
import com.example.justyourkidiez.domain.Parent.Parent;
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
public class GetParentUseCaseImplTest {

    @InjectMocks
    private GetParentUseCaseImpl useCase;

    @Mock
    private ParentRepository parentRepository;

    @Mock
    private AccessToken requestAccessToken;

    @Test
    public void getParent() {
        long parentId = 1L;

        when(requestAccessToken.hasRole(RoleEnum.PARENT.name())).thenReturn(true);
        ParentEntity parentEntity = new ParentEntity();
        parentEntity.setId(parentId);
        when(parentRepository.findById(parentId)).thenReturn(Optional.of(parentEntity));

        Optional<Parent> result = useCase.getParent(parentId);

        verify(requestAccessToken, times(1)).hasRole(RoleEnum.PARENT.name());
        verify(parentRepository, times(1)).findById(parentId);

        assertTrue(result.isPresent());
        assertEquals(parentId, result.get().getId());
    }

    @Test
    public void getNoParent() {
        long parentId = 2L;

        when(requestAccessToken.hasRole(RoleEnum.PARENT.name())).thenReturn(false);
        when(requestAccessToken.getParentId()).thenReturn(1L);

        assertThrows(UnauthorizedDataAccessException.class, () -> useCase.getParent(parentId));

        verify(requestAccessToken, times(1)).hasRole(RoleEnum.PARENT.name());
        verify(requestAccessToken, times(1)).getParentId();
        verify(parentRepository, never()).findById(anyLong());
    }
}

