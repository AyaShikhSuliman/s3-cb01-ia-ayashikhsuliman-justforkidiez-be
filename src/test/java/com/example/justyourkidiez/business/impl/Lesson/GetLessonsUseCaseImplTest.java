package com.example.justyourkidiez.business.impl.Lesson;

import com.example.justyourkidiez.domain.Course.GetCoursesResponse;
import com.example.justyourkidiez.domain.Lesson.GetLessonsResponse;
import com.example.justyourkidiez.persistence.LessonRepository;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import com.example.justyourkidiez.persistence.entity.Lesson.LessonEntity;
import com.example.justyourkidiez.persistence.entity.Lesson.StatusEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetLessonsUseCaseImplTest {
    @Mock
    private LessonRepository lessonRepository;

    @Mock
    private LessonEntity lessonEntity1;

    @Mock
    private LessonEntity lessonEntity2;

    @InjectMocks
    private GetLessonsUseCaseImpl getLessonsUseCase;

    @Test
    public void getLessons() {
        when(lessonRepository.findAll()).thenReturn(Arrays.asList(lessonEntity1, lessonEntity2));

        GetLessonsResponse response = getLessonsUseCase.getLessons();

        List<LessonEntity> lessons = response.getLessons();
        Assertions.assertEquals(2, lessons.size());
        Assertions.assertFalse(lessons.contains(lessonEntity1));
        Assertions.assertFalse(lessons.contains(lessonEntity2));
    }

    @Test
    public void getLessonByCourseId() {
        long courseId = 123L;
        when(lessonRepository.getLessonEntitiesByCourseId(courseId)).thenReturn(Arrays.asList(lessonEntity1, lessonEntity2));

        GetLessonsResponse response = getLessonsUseCase.getLessonEntitiesByCourseId(courseId);

        List<LessonEntity> lessons = response.getLessons();
        Assertions.assertEquals(2, lessons.size());
        Assertions.assertFalse(lessons.contains(lessonEntity1));
        Assertions.assertFalse(lessons.contains(lessonEntity2));
    }
}
