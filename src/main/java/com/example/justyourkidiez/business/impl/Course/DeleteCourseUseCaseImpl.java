package com.example.justyourkidiez.business.impl.Course;

import com.example.justyourkidiez.business.UseCases.Course.DeleteCourseUseCase;
import com.example.justyourkidiez.persistence.CourseRepository;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteCourseUseCaseImpl implements DeleteCourseUseCase {
    private final CourseRepository courseRepository;

    @Override
    @Transactional
    public void deleteCourse(long courseId) {
        CourseEntity course = courseRepository.findById(courseId).get();

        if (!course.getLessons().isEmpty()) {
            throw new RuntimeException("Course cannot be deleted!");
        } else if(course.getLessons().isEmpty())
        {
            courseRepository.deleteById(course.getId());
        }
    }
}
