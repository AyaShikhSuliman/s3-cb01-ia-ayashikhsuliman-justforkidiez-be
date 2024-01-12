package com.example.justyourkidiez.persistence.entity.Course;

import lombok.*;

@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
@ToString
public class CoursesWithNumberOfLessonsEntity {
    private CourseEntity course;
    private long count;
}
