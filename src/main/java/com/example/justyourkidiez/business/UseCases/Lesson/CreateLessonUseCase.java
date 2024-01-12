package com.example.justyourkidiez.business.UseCases.Lesson;

import com.example.justyourkidiez.domain.Lesson.CreateLessonRequest;
import com.example.justyourkidiez.domain.Lesson.CreateLessonResponse;
import com.example.justyourkidiez.domain.Parent.CreateParentRequest;
import com.example.justyourkidiez.domain.Parent.CreateParentResponse;

public interface CreateLessonUseCase {
    CreateLessonResponse createLesson(CreateLessonRequest request);
}
