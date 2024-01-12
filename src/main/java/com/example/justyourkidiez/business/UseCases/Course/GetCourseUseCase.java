package com.example.justyourkidiez.business.UseCases.Course;

import com.example.justyourkidiez.domain.Lesson.Lesson;
import com.example.justyourkidiez.domain.Parent.Parent;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import com.example.justyourkidiez.persistence.entity.Lesson.LessonEntity;

import java.util.Optional;

public interface GetCourseUseCase {
    Optional<CourseEntity> getCourse(long courseId);
}
