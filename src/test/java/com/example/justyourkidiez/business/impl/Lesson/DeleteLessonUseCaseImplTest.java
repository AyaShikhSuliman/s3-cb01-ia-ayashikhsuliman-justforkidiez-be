package com.example.justyourkidiez.business.impl.Lesson;

import com.example.justyourkidiez.persistence.LessonRepository;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import com.example.justyourkidiez.persistence.entity.Lesson.LessonEntity;
import com.example.justyourkidiez.persistence.entity.Lesson.StatusEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class DeleteLessonUseCaseImplTest {
    @Mock
    private LessonRepository lessonRepositoryMock;
    @InjectMocks
    private DeleteLessonUseCaseImpl deleteLessonUseCase;
    @Test
    void deleteLesson() {
        CourseEntity course = CourseEntity.builder()
                .id(1L)
                .image("test")
                .title("test")
                .description("test")
                .build();

        LessonEntity lesson = LessonEntity.builder()
                .id(1L)
                .image("test")
                .video("test")
                .title("test")
                .description("test")
                .course(course)
                .lessonStatus(StatusEnum.UNFINISHED)
                .build();

        deleteLessonUseCase.deleteLesson(lesson.getId());
        verify(lessonRepositoryMock, times(1)).deleteById(lesson.getId());
    }
}
