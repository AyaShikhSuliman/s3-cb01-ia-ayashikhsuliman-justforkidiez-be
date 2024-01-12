package com.example.justyourkidiez.business.impl.Parent;

import com.example.justyourkidiez.persistence.ParentRepository;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import com.example.justyourkidiez.persistence.entity.Lesson.LessonEntity;
import com.example.justyourkidiez.persistence.entity.Lesson.StatusEnum;
import com.example.justyourkidiez.persistence.entity.ParentEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DeleteParentUseCaseImplTest {
    @Mock
    private ParentRepository parentRepositoryMock;
    @InjectMocks
    private DeleteParentUseCaseImpl deleteParentUseCase;
    @Test
    void deleteParent() {
        ParentEntity parent = ParentEntity.builder()
                .id(1L)
                .name("test")
                .last_name("test")
                .age(12L)
                .phone_number("test")
                .email_address("test@gmail.com")
                .country("test")
                .course(CourseEntity.builder().build())
                .build();

        deleteParentUseCase.deleteParent(parent.getId());
        verify(parentRepositoryMock, times(1)).deleteById(parent.getId());
    }
}
