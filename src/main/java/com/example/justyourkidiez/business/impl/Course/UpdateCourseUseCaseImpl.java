package com.example.justyourkidiez.business.impl.Course;

import com.example.justyourkidiez.business.UseCases.Course.UpdateCourseUseCase;
import com.example.justyourkidiez.domain.Course.UpdateCourseRequest;
import com.example.justyourkidiez.persistence.CourseRepository;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateCourseUseCaseImpl implements UpdateCourseUseCase {
    private final CourseRepository courseRepository;

    @Transactional
    @Override
    public void updateCourse(UpdateCourseRequest request) {
        Optional<CourseEntity> optionalCourse = courseRepository.findById(request.getId());
        CourseEntity course = optionalCourse.get();
        updateFields(request, course);
    }

    private void updateFields(UpdateCourseRequest request, CourseEntity course) {
        course.setImage(request.getImage());
        course.setDescription(request.getDescription());
        courseRepository.save(course);
    }
}
