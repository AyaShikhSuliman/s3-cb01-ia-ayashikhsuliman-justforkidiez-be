package com.example.justyourkidiez.business.impl.Course;

import com.example.justyourkidiez.business.UseCases.Course.GetCoursesUseCase;
import com.example.justyourkidiez.domain.Course.Course;
import com.example.justyourkidiez.domain.Course.GetCoursesResponse;
import com.example.justyourkidiez.persistence.CourseRepository;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetCoursesUseCaseImpl implements GetCoursesUseCase {
    private final CourseRepository courseRepository;

    @Override
    public GetCoursesResponse getCourses() {
        List<CourseEntity> courses = courseRepository.findAll()
                .stream()
                .map(CourseConverter::convert)
                .toList();

        return GetCoursesResponse.builder()
                .courses(courses)
                .build();
    }
}
