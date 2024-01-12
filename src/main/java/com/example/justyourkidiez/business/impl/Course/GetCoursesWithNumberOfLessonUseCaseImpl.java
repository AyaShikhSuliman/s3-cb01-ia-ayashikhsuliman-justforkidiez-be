package com.example.justyourkidiez.business.impl.Course;

import com.example.justyourkidiez.business.UseCases.Course.GetCoursesWithNumberOfLessonsUseCase;
import com.example.justyourkidiez.domain.Course.GetCoursesWithNumberOfLessonsResponse;
import com.example.justyourkidiez.persistence.CourseLessonsRepository;
import com.example.justyourkidiez.persistence.entity.Course.CoursesWithNumberOfLessonsEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetCoursesWithNumberOfLessonUseCaseImpl implements GetCoursesWithNumberOfLessonsUseCase {
    private final CourseLessonsRepository courseLessonsRepository;

    @Override
    public GetCoursesWithNumberOfLessonsResponse getCoursesWithNumberOfLessons() {
        List<CoursesWithNumberOfLessonsEntity> numberOfLessonsPerCourseEntities = courseLessonsRepository.getCoursesWithNumberOfLessons()
                .stream()
                .map(LessonPerCourseConverter::convert)
                .toList();

        return GetCoursesWithNumberOfLessonsResponse.builder()
                .numberOfLessonsPerCourseEntities(numberOfLessonsPerCourseEntities)
                .build();
    }
}
