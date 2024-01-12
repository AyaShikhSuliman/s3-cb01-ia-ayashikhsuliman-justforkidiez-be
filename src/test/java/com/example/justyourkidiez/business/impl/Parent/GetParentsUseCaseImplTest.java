package com.example.justyourkidiez.business.impl.Parent;

import com.example.justyourkidiez.domain.Parent.GetAllParentsRequest;
import com.example.justyourkidiez.domain.Parent.GetAllParentsResponse;
import com.example.justyourkidiez.domain.Parent.Parent;
import com.example.justyourkidiez.persistence.ParentRepository;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import com.example.justyourkidiez.persistence.entity.ParentEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetParentsUseCaseImplTest {
    @Mock
    private ParentRepository parentRepositoryMock;

    @InjectMocks
    private GetParentsUseCaseImpl parentsUseCase;

    @Test
    void getParents() {
        ParentEntity parent1 = ParentEntity.builder().id(1L).name("test").last_name("test").age(12L).phone_number("test").email_address("test@gmail.com").country("test").course(CourseEntity.builder().build()).build();
        ParentEntity parent2 = ParentEntity.builder().id(1L).name("test").last_name("test").age(12L).phone_number("test").email_address("test@gmail.com").country("test").course(CourseEntity.builder().build()).build();

        when(parentRepositoryMock.findAll())
                .thenReturn(List.of(parent1, parent2));

        GetAllParentsResponse actualResult = parentsUseCase.getParents();

        Parent parent3 = Parent.builder().id(1L).name("test").last_name("test").age(12L).phone_number("test").email_address("test@gmail.com").country("test").course(CourseEntity.builder().build()).build();
        Parent parent4 = Parent.builder().id(1L).name("test").last_name("test").age(12L).phone_number("test").email_address("test@gmail.com").country("test").course(CourseEntity.builder().build()).build();

        GetAllParentsResponse expectedResult = GetAllParentsResponse
                .builder()
                .parents(List.of(parent3, parent4))
                .build();

        assertEquals(expectedResult, actualResult);

        verify(parentRepositoryMock).findAll();
    }
}
