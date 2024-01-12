package com.example.justyourkidiez.business.impl.Lesson;

import com.example.justyourkidiez.business.UseCases.Lesson.GetLessonUseCase;
import com.example.justyourkidiez.persistence.LessonRepository;
import com.example.justyourkidiez.persistence.entity.Lesson.LessonEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetLessonUseCaseImpl implements GetLessonUseCase {
    private LessonRepository lessonRepository;


    @Override
    public Optional<LessonEntity> getLesson(long lessonId) {
        return lessonRepository.findById(lessonId).map(LessonConverter::convert);
    }
}
