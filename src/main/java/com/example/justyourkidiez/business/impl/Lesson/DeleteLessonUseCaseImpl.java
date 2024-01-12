package com.example.justyourkidiez.business.impl.Lesson;

import com.example.justyourkidiez.business.UseCases.Lesson.DeleteLessonUseCase;
import com.example.justyourkidiez.persistence.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteLessonUseCaseImpl implements DeleteLessonUseCase {
    private final LessonRepository lessonRepository;
    @Override
    @Transactional
    public void deleteLesson(long lessonId) {
        this.lessonRepository.deleteById(lessonId);
    }
}

