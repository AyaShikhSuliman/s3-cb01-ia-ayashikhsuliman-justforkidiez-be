package com.example.justyourkidiez.business.UseCases.Course;

import com.example.justyourkidiez.domain.Course.UpdateCourseRequest;
import com.example.justyourkidiez.domain.Lesson.UpdateLessonRequest;

public interface UpdateCourseUseCase {
    void updateCourse(UpdateCourseRequest request);
}
