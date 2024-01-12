package com.example.justyourkidiez.business.impl.Parent;

import com.example.justyourkidiez.business.exception.NameAlreadyExistsException;
import com.example.justyourkidiez.domain.Parent.CreateParentRequest;
import com.example.justyourkidiez.domain.Parent.CreateParentResponse;
import com.example.justyourkidiez.persistence.ParentRepository;
import com.example.justyourkidiez.persistence.UserRepository;
import com.example.justyourkidiez.persistence.entity.ParentEntity;
import com.example.justyourkidiez.persistence.entity.User.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateParentUseCaseImpTest {
    @InjectMocks
    private CreateParentUseCaseImpl useCase;

    @Mock
    private ParentRepository parentRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    public void createParent() {
        CreateParentRequest request = new CreateParentRequest();
        request.setName("John");
        request.setLast_name("Doe");
        request.setAge(30L);
        request.setPhone_number("123456789");
        request.setEmail_address("john@example.com");
        request.setCountry("USA");
        request.setPassword("password123");

        when(parentRepository.existsByName(request.getName())).thenReturn(false);

        ParentEntity savedParent = new ParentEntity();
        savedParent.setId(1L);
        when(parentRepository.save(any(ParentEntity.class))).thenReturn(savedParent);

        UserEntity savedUser = new UserEntity();
        savedUser.setId(1L);
        when(userRepository.save(any(UserEntity.class))).thenReturn(savedUser);

        CreateParentResponse response = useCase.createParent(request);

        verify(parentRepository, times(1)).existsByName(request.getName());
        verify(parentRepository, times(1)).save(any(ParentEntity.class));
        verify(userRepository, times(1)).save(any(UserEntity.class));

        assertNotNull(response);
        assertEquals(savedParent.getId(), response.getParentId());
    }

    @Test
    public void createParentWithExistingName() {
        CreateParentRequest request = new CreateParentRequest();
        request.setName("John");

        when(parentRepository.existsByName(request.getName())).thenReturn(true);

        assertThrows(NameAlreadyExistsException.class, () -> useCase.createParent(request));

        verify(parentRepository, times(1)).existsByName(request.getName());
        verify(parentRepository, never()).save(any(ParentEntity.class));
        verify(userRepository, never()).save(any(UserEntity.class));
    }
}
