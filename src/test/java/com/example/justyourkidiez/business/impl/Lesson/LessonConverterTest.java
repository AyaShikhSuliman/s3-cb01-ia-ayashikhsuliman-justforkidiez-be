package com.example.justyourkidiez.business.impl.Lesson;

import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import com.example.justyourkidiez.persistence.entity.Lesson.LessonEntity;
import com.example.justyourkidiez.persistence.entity.Lesson.StatusEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LessonConverterTest {

    @Test
    public void convert() {
        LessonEntity inputLesson = new LessonEntity();
        inputLesson.setId(1L);
        inputLesson.setImage("lesson_image.jpg");
        inputLesson.setVideo("lesson_video.mp4");
        inputLesson.setTitle("Sample Lesson");
        inputLesson.setDescription("This is a sample lesson");
        inputLesson.setCourse(CourseEntity.builder().build());
        inputLesson.setLessonStatus(StatusEnum.UNFINISHED);

        LessonEntity resultLesson = LessonConverter.convert(inputLesson);

        assertEquals(inputLesson.getId(), resultLesson.getId());
        assertEquals(inputLesson.getImage(), resultLesson.getImage());
        assertEquals(inputLesson.getVideo(), resultLesson.getVideo());
        assertEquals(inputLesson.getTitle(), resultLesson.getTitle());
        assertEquals(inputLesson.getDescription(), resultLesson.getDescription());
        assertEquals(inputLesson.getCourse(), resultLesson.getCourse());
        assertEquals(inputLesson.getLessonStatus(), resultLesson.getLessonStatus());
    }
}

