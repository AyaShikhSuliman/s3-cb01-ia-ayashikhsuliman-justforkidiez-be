package com.example.justyourkidiez.business.UseCases.Lesson;

import com.example.justyourkidiez.domain.Lesson.Lesson;
import com.example.justyourkidiez.domain.Parent.Parent;
import com.example.justyourkidiez.persistence.entity.Lesson.LessonEntity;

import java.util.Optional;

public interface GetLessonUseCase {
    Optional<LessonEntity> getLesson(long lessonId);
}
