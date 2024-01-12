package com.example.justyourkidiez.business.UseCases.Lesson;

import com.example.justyourkidiez.domain.Lesson.UpdateLessonRequest;
import com.example.justyourkidiez.domain.Parent.UpdateParentRequest;

public interface UpdateLessonUseCase {
    void updateLesson(UpdateLessonRequest request);
}
