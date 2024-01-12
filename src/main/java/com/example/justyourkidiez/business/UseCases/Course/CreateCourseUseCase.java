package com.example.justyourkidiez.business.UseCases.Course;

import com.example.justyourkidiez.domain.Course.CreateCourseRequest;
import com.example.justyourkidiez.domain.Course.CreateCourseResponse;

public interface CreateCourseUseCase {
    CreateCourseResponse createCourse(CreateCourseRequest request);
}
