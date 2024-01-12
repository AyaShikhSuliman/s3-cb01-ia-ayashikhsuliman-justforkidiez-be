package com.example.justyourkidiez.domain.Course;

import com.example.justyourkidiez.persistence.entity.Course.CoursesWithNumberOfLessonsEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GetCoursesWithNumberOfLessonsResponse {
    private List<CoursesWithNumberOfLessonsEntity> numberOfLessonsPerCourseEntities;
}
