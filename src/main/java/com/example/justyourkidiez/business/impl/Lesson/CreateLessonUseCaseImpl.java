package com.example.justyourkidiez.business.impl.Lesson;

import com.example.justyourkidiez.business.UseCases.Lesson.CreateLessonUseCase;
import com.example.justyourkidiez.business.exception.InvalidLessonException;
import com.example.justyourkidiez.domain.Lesson.CreateLessonRequest;
import com.example.justyourkidiez.domain.Lesson.CreateLessonResponse;
import com.example.justyourkidiez.persistence.CourseRepository;
import com.example.justyourkidiez.persistence.LessonRepository;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import com.example.justyourkidiez.persistence.entity.Lesson.LessonEntity;
import com.example.justyourkidiez.persistence.entity.Lesson.StatusEnum;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class CreateLessonUseCaseImpl implements CreateLessonUseCase {
    private final LessonRepository lessonRepository;
    private CourseRepository courseRepository;
    @Transactional
    @Override
    public CreateLessonResponse createLesson(CreateLessonRequest request) {

        if (lessonRepository.existsByTitle(request.getTitle())) {
            throw new InvalidLessonException();
        }

        CourseEntity course = courseRepository.findCourseEntityById(request.getCourseId());

        LessonEntity newLesson = LessonEntity.builder()
                .image(request.getImage())
                .video(request.getVideo())
                .title(request.getTitle())
                .description(request.getDescription())
                .course(course)
                .lessonStatus(StatusEnum.UNFINISHED)
                .build();

        LessonEntity savedLesson = lessonRepository.save(newLesson);

        return CreateLessonResponse.builder()
                .lessonId(savedLesson.getId())
                .build();
    }
}
