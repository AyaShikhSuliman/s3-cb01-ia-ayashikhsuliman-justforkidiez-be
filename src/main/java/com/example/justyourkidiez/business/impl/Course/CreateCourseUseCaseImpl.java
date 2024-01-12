package com.example.justyourkidiez.business.impl.Course;

import com.example.justyourkidiez.business.UseCases.Course.CreateCourseUseCase;
import com.example.justyourkidiez.business.exception.InvalidCourseException;
import com.example.justyourkidiez.domain.Course.CreateCourseRequest;
import com.example.justyourkidiez.domain.Course.CreateCourseResponse;
import com.example.justyourkidiez.persistence.CourseRepository;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class CreateCourseUseCaseImpl implements CreateCourseUseCase {
    private final CourseRepository courseRepository;

    @Transactional
    @Override
    public CreateCourseResponse createCourse(CreateCourseRequest request) {

        if (courseRepository.existsByTitle(request.getTitle())) {
            throw new InvalidCourseException();
        }

        CourseEntity newCourse = CourseEntity.builder()
                .image(request.getImage())
                .title(request.getTitle())
                .description(request.getDescription())
                .build();

        CourseEntity savedCourse = courseRepository.save(newCourse);

        return CreateCourseResponse.builder()
                .id(savedCourse.getId())
                .build();
    }
}