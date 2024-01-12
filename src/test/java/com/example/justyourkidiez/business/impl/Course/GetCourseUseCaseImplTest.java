package com.example.justyourkidiez.business.impl.Course;

import com.example.justyourkidiez.persistence.CourseRepository;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetCourseUseCaseImplTest {
    @Mock
    private CourseRepository courseRepository;

    @Test
    public void getCourse() {
        CourseEntity courseEntity = CourseEntity.builder()
                .id(1L)
                .image("image.png")
                .title("Course Title")
                .description("Course Description")
                .build();

        when(courseRepository.findById(1L)).thenReturn(Optional.of(courseEntity));

        GetCourseUseCaseImpl useCase = new GetCourseUseCaseImpl(courseRepository);

        Optional<CourseEntity> courseOptional = useCase.getCourse(1L);

        verify(courseRepository, times(1)).findById(1L);

        assertTrue(courseOptional.isPresent());
        CourseEntity retrievedCourse = courseOptional.get();
        assertEquals(courseEntity.getId(), retrievedCourse.getId());
        assertEquals(courseEntity.getImage(), retrievedCourse.getImage());
        assertEquals(courseEntity.getTitle(), retrievedCourse.getTitle());
        assertEquals(courseEntity.getDescription(), retrievedCourse.getDescription());
    }

    @Test
    public void getNoCourse() {
        when(courseRepository.findById(2L)).thenReturn(Optional.empty());

        GetCourseUseCaseImpl useCase = new GetCourseUseCaseImpl(courseRepository);

        Optional<CourseEntity> courseOptional = useCase.getCourse(2L);

        verify(courseRepository, times(1)).findById(2L);

        assertFalse(courseOptional.isPresent());
    }
}

