package com.example.justyourkidiez.business.impl.Course;

import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CourseConverterTest {
    @Test
    public void convert() {
        CourseEntity inputCourse = CourseEntity.builder()
                .id(1L)
                .image("image.jpg")
                .title("Course Title")
                .description("Course Description")
                .build();

        CourseEntity result = CourseConverter.convert(inputCourse);

        assertEquals(inputCourse.getId(), result.getId());
        assertEquals(inputCourse.getImage(), result.getImage());
        assertEquals(inputCourse.getTitle(), result.getTitle());
        assertEquals(inputCourse.getDescription(), result.getDescription());
    }
}



