package com.example.justyourkidiez.business.impl.Course;

import com.example.justyourkidiez.domain.Course.UpdateCourseRequest;
import com.example.justyourkidiez.persistence.CourseRepository;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UpdateCourseUseCaseImplTest {
    @Mock
    private CourseRepository courseRepositoryMock;
    @InjectMocks
    private UpdateCourseUseCaseImpl updateCourseUseCase;

    @Test
    void updateCourse() {
        UpdateCourseRequest request = UpdateCourseRequest.builder()
                .id(1L)
                .image("test1")
                .description("test2")
                .build();

        CourseEntity course = getCourse(request);

        when(courseRepositoryMock.findById(request.getId())).thenReturn(Optional.ofNullable(course));

        updateCourseUseCase.updateCourse(request);

        verify(courseRepositoryMock, times(1)).save(course);
    }

    private CourseEntity getCourse(UpdateCourseRequest request) {

        CourseEntity course = CourseEntity.builder()
                .id(request.getId())
                .image("test")
                .description("test")
                .build();

        return course;
    }
}

