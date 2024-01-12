package com.example.justyourkidiez.business.impl.Lesson;

import com.example.justyourkidiez.persistence.LessonRepository;
import com.example.justyourkidiez.persistence.entity.Lesson.LessonEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetLessonUseCaseImplTest {
    @InjectMocks
    private GetLessonUseCaseImpl useCase;

    @Mock
    private LessonRepository lessonRepository;

    @Test
    public void getLesson() {
        long lessonId = 123;
        LessonEntity expectedLessonEntity = new LessonEntity();

        when(lessonRepository.findById(lessonId)).thenReturn(Optional.of(expectedLessonEntity));

        Optional<LessonEntity> resultOptional = useCase.getLesson(lessonId);

        verify(lessonRepository, times(1)).findById(lessonId);
        assertEquals(Optional.of(expectedLessonEntity), resultOptional);
    }

    @Test
    public void getNoLesson() {
        long lessonId = 456;

        when(lessonRepository.findById(lessonId)).thenReturn(Optional.empty());

        Optional<LessonEntity> resultOptional = useCase.getLesson(lessonId);

        verify(lessonRepository, times(1)).findById(lessonId);
        assertEquals(Optional.empty(), resultOptional);
    }
}

