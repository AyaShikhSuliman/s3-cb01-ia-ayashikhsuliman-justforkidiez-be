package com.example.justyourkidiez.business.impl.Lesson;

import com.example.justyourkidiez.business.UseCases.Lesson.GetLessonsUseCase;
import com.example.justyourkidiez.domain.Lesson.GetLessonsResponse;
import com.example.justyourkidiez.domain.Lesson.Lesson;
import com.example.justyourkidiez.persistence.LessonRepository;
import com.example.justyourkidiez.persistence.entity.Lesson.LessonEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class GetLessonsUseCaseImpl implements GetLessonsUseCase {
    private final LessonRepository lessonRepository;

    @Override
    public GetLessonsResponse getLessons() {
        List<LessonEntity> lessons = lessonRepository.findAll()
                .stream()
                .map(LessonConverter::convert)
                .toList();

        return GetLessonsResponse.builder()
                .lessons(lessons)
                .build();
    }

    @Transactional
    @Override
    public GetLessonsResponse getLessonEntitiesByCourseId(long courseId) {
        List<LessonEntity> lessons = lessonRepository.getLessonEntitiesByCourseId(courseId)
                .stream()
                .map(LessonConverter::convert)
                .toList();

        GetLessonsResponse response = GetLessonsResponse.builder().lessons(lessons).build();

        return response;
    }
}
