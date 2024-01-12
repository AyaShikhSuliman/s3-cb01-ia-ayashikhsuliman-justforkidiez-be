package com.example.justyourkidiez.business.impl.Lesson;

import com.example.justyourkidiez.domain.Course.UpdateCourseRequest;
import com.example.justyourkidiez.domain.Lesson.UpdateLessonRequest;
import com.example.justyourkidiez.persistence.LessonRepository;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import com.example.justyourkidiez.persistence.entity.Lesson.LessonEntity;
import com.example.justyourkidiez.persistence.entity.Lesson.StatusEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UpdateLessonUseCaseImplTest {
    @Mock
    private LessonRepository lessonRepositoryMock;
    @InjectMocks
    private UpdateLessonUseCaseImpl updateLessonUseCase;

    @Test
    void updateLesson() {
        UpdateLessonRequest request = UpdateLessonRequest.builder()
                .id(1L)
                .image("test")
                .video("test")
                .description("test")
                .courseId(0)
                .lessonStatus("UNFINISHED")
                .build();

        LessonEntity lesson = getLesson(request);

        when(lessonRepositoryMock.findById(request.getId())).thenReturn(Optional.ofNullable(lesson));

        updateLessonUseCase.updateLesson(request);

        verify(lessonRepositoryMock, times(1)).save(lesson);
    }

    private LessonEntity getLesson(UpdateLessonRequest request) {

        LessonEntity lesson = LessonEntity.builder()
                .id(request.getId())
                .image("test")
                .video("test")
                .description("test")
                .course(CourseEntity.builder().build())
                .lessonStatus(StatusEnum.UNFINISHED)
                .build();

        return lesson;
    }
}
