package com.example.justyourkidiez.business.impl.Course;

import com.example.justyourkidiez.domain.Course.Course;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;

public final class CourseConverter {
    private CourseConverter() {
    }

    public static CourseEntity convert(CourseEntity courseEntity) {
        return CourseEntity.builder()
                .id(courseEntity.getId())
                .image(courseEntity.getImage())
                .title(courseEntity.getTitle())
                .description(courseEntity.getDescription())
                .build();
    }
}
