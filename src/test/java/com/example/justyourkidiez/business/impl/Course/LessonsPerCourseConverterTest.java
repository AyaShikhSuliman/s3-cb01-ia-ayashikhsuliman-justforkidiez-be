package com.example.justyourkidiez.business.impl.Course;

import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import com.example.justyourkidiez.persistence.entity.Course.CoursesWithNumberOfLessonsEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LessonsPerCourseConverterTest {

    @Test
    public void convert() {
        CoursesWithNumberOfLessonsEntity inputEntity = CoursesWithNumberOfLessonsEntity.builder()
                .course(CourseEntity.builder().build())
                .count(10)
                .build();

        CoursesWithNumberOfLessonsEntity convertedEntity = LessonPerCourseConverter.convert(inputEntity);

        assertNotNull(convertedEntity);
        assertEquals(inputEntity.getCourse(), convertedEntity.getCourse());
        assertEquals(inputEntity.getCount(), convertedEntity.getCount());
    }
}

