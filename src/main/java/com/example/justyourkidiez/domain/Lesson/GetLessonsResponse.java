package com.example.justyourkidiez.domain.Lesson;

import com.example.justyourkidiez.domain.Course.Course;
import com.example.justyourkidiez.persistence.entity.Lesson.LessonEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GetLessonsResponse {
    private List<LessonEntity> lessons;

}
