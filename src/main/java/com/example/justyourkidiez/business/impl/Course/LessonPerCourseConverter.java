package com.example.justyourkidiez.business.impl.Course;

import com.example.justyourkidiez.persistence.entity.Course.CoursesWithNumberOfLessonsEntity;

public class LessonPerCourseConverter {
    public static CoursesWithNumberOfLessonsEntity convert(CoursesWithNumberOfLessonsEntity lesson) {

        return CoursesWithNumberOfLessonsEntity.builder()
                .course(lesson.getCourse())
                .count(lesson.getCount())
                .build();
    }
}
