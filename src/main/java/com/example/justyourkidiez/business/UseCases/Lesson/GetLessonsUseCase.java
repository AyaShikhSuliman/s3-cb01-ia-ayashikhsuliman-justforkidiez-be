package com.example.justyourkidiez.business.UseCases.Lesson;

import com.example.justyourkidiez.domain.Course.GetCoursesResponse;
import com.example.justyourkidiez.domain.Lesson.GetLessonsResponse;
import com.example.justyourkidiez.domain.Parent.GetAllParentsRequest;
import com.example.justyourkidiez.domain.Parent.GetAllParentsResponse;

public interface GetLessonsUseCase {
    GetLessonsResponse getLessons();

    GetLessonsResponse getLessonEntitiesByCourseId(long courseId);

}
