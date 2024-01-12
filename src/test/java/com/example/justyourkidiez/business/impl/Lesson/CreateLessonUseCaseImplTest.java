package com.example.justyourkidiez.business.impl.Lesson;

import com.example.justyourkidiez.business.exception.InvalidLessonException;
import com.example.justyourkidiez.domain.Course.Course;
import com.example.justyourkidiez.domain.Course.CreateCourseRequest;
import com.example.justyourkidiez.domain.Course.CreateCourseResponse;
import com.example.justyourkidiez.domain.Lesson.CreateLessonRequest;
import com.example.justyourkidiez.domain.Lesson.CreateLessonResponse;
import com.example.justyourkidiez.domain.Lesson.Lesson;
import com.example.justyourkidiez.persistence.CourseRepository;
import com.example.justyourkidiez.persistence.LessonRepository;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import com.example.justyourkidiez.persistence.entity.Lesson.LessonEntity;
import com.example.justyourkidiez.persistence.entity.Lesson.StatusEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateLessonUseCaseImplTest {

    @Mock
    private LessonRepository lessonRepository;

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CreateLessonUseCaseImpl createLessonUseCase;

    @Test
    public void testCreateLesson_LessonNotExists_Success() {
        long courseId = 1L;
        long lessonId = 2L;
        CreateLessonRequest request = new CreateLessonRequest("Title", "Image", "Video", "Description", courseId);
        CourseEntity courseEntity = new CourseEntity();
        LessonEntity savedLessonEntity = new LessonEntity();
        savedLessonEntity.setId(lessonId);

        when(lessonRepository.existsByTitle(request.getTitle())).thenReturn(false);
        when(courseRepository.findCourseEntityById(courseId)).thenReturn(courseEntity);
        when(lessonRepository.save(any(LessonEntity.class))).thenReturn(savedLessonEntity);

        CreateLessonResponse response = createLessonUseCase.createLesson(request);

        Assertions.assertEquals(lessonId, response.getLessonId());

        verify(lessonRepository, times(1)).existsByTitle(request.getTitle());
        verify(courseRepository, times(1)).findCourseEntityById(courseId);
        verify(lessonRepository, times(1)).save(any(LessonEntity.class));
    }

    @Test
    public void testCreateLesson_LessonExists_ExceptionThrown() {
        CreateLessonRequest request = new CreateLessonRequest("Title", "Image", "Video", "Description", 1L);

        when(lessonRepository.existsByTitle(request.getTitle())).thenReturn(true);

        Assertions.assertThrows(InvalidLessonException.class, () -> {
            createLessonUseCase.createLesson(request);
        });

        verify(lessonRepository, times(1)).existsByTitle(request.getTitle());
        verify(courseRepository, never()).findCourseEntityById(anyLong());
        verify(lessonRepository, never()).save(any(LessonEntity.class));
    }
}
