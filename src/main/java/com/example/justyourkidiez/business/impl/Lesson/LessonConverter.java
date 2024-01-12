package com.example.justyourkidiez.business.impl.Lesson;

import com.example.justyourkidiez.persistence.entity.Lesson.LessonEntity;

public class LessonConverter {

    public static LessonEntity convert(LessonEntity lesson) {

        return LessonEntity.builder()
                .id(lesson.getId())
                .image(lesson.getImage())
                .video(lesson.getVideo())
                .title(lesson.getTitle())
                .description(lesson.getDescription())
                .course(lesson.getCourse())
                .lessonStatus(lesson.getLessonStatus())
                .build();
    }
}
