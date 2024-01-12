package com.example.justyourkidiez.business.impl.Course;

import com.example.justyourkidiez.persistence.CourseRepository;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import com.example.justyourkidiez.persistence.entity.Lesson.LessonEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeleteCourseUseCaseImplTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private DeleteCourseUseCaseImpl deleteCourseUseCase;

    @Test
    public void deleteCourseWithoutLessons() {
        long courseId = 1L;
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(courseId);
        courseEntity.setLessons(Collections.emptyList());

        when(courseRepository.findById(courseId)).thenReturn(Optional.of(courseEntity));

        deleteCourseUseCase.deleteCourse(courseId);

        verify(courseRepository, times(1)).findById(courseId);
        verify(courseRepository, times(1)).deleteById(courseId);
    }

    @Test
    public void deleteCourseCourseWithLessons() {
        long courseId = 1L;
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(courseId);
        courseEntity.setLessons(Collections.singletonList(new LessonEntity()));

        when(courseRepository.findById(courseId)).thenReturn(Optional.of(courseEntity));

        Assertions.assertThrows(RuntimeException.class, () -> {
            deleteCourseUseCase.deleteCourse(courseId);
        });

        verify(courseRepository, times(1)).findById(courseId);
        verify(courseRepository, never()).deleteById(anyLong());
    }

    @Test
    public void deleteCourseWhenCourseNotFound() {
        long courseId = 1L;

        when(courseRepository.findById(courseId)).thenReturn(Optional.empty());

        Assertions.assertThrows(RuntimeException.class, () -> {
            deleteCourseUseCase.deleteCourse(courseId);
        });

        verify(courseRepository, times(1)).findById(courseId);
        verify(courseRepository, never()).deleteById(anyLong());
    }
}

