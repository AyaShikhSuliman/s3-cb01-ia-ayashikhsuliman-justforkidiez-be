package com.example.justyourkidiez.business.impl.Lesson;

import com.example.justyourkidiez.business.UseCases.Lesson.UpdateLessonUseCase;
import com.example.justyourkidiez.domain.Lesson.UpdateLessonRequest;
import com.example.justyourkidiez.persistence.LessonRepository;
import com.example.justyourkidiez.persistence.entity.Lesson.LessonEntity;
import com.example.justyourkidiez.persistence.entity.Lesson.StatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateLessonUseCaseImpl implements UpdateLessonUseCase {
    private final LessonRepository lessonRepository;

    //    @Transactional
    @Override
    public void updateLesson(UpdateLessonRequest request) {
        Optional<LessonEntity> optionalLesson = lessonRepository.findById(request.getId());

        LessonEntity lesson = optionalLesson.get();
        updateFields(request, lesson);
    }

    private void updateFields(UpdateLessonRequest request, LessonEntity lesson) {
        lesson.setImage(request.getImage());
        lesson.setVideo(request.getVideo());
        lesson.setDescription((request.getDescription()));
        StatusEnum lessonStatus = StatusEnum.valueOf(request.getLessonStatus());
        lesson.setLessonStatus(lessonStatus);
//        lesson.setCourse(request.getCourseId());
        lessonRepository.save(lesson);
    }
}
