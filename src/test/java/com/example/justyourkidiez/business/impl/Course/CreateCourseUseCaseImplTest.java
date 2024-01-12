package com.example.justyourkidiez.business.impl.Course;

import com.example.justyourkidiez.business.exception.InvalidCourseException;
import com.example.justyourkidiez.domain.Course.Course;
import com.example.justyourkidiez.domain.Course.CreateCourseRequest;
import com.example.justyourkidiez.domain.Course.CreateCourseResponse;
import com.example.justyourkidiez.persistence.CourseRepository;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateCourseUseCaseImplTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CreateCourseUseCaseImpl createCourseUseCase;

    @Test
    public void createCourse() {
        when(courseRepository.existsByTitle(any())).thenReturn(false);
        when(courseRepository.save(any())).thenAnswer(invocation -> {
            CourseEntity courseEntity = invocation.getArgument(0);
            courseEntity.setId(1L);
            return courseEntity;
        });

        CreateCourseRequest request = new CreateCourseRequest("Title", "Image", "Description");

        CreateCourseResponse response = createCourseUseCase.createCourse(request);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1L, response.getId());
    }

    @Test
    public void CreateInvalidCourse(){
        when(courseRepository.existsByTitle(any())).thenReturn(true);

        CreateCourseRequest request = new CreateCourseRequest("Title", "Image", "Description");

        Assertions.assertThrows(InvalidCourseException.class, () -> {
            createCourseUseCase.createCourse(request);
        });
    }
}
