package com.example.justyourkidiez.business.impl.Course;

import com.example.justyourkidiez.business.UseCases.Course.GetCourseUseCase;
import com.example.justyourkidiez.business.impl.Course.CourseConverter;
import com.example.justyourkidiez.persistence.CourseRepository;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetCourseUseCaseImpl implements GetCourseUseCase {
    private CourseRepository courseRepository;


    @Override
    public Optional<CourseEntity> getCourse(long courseId) {
        return courseRepository.findById(courseId).map(CourseConverter::convert);
    }
}
