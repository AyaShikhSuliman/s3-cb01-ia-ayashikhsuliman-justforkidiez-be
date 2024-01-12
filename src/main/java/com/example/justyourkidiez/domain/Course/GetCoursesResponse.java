package com.example.justyourkidiez.domain.Course;

import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import lombok.*;

import java.util.List;

@Builder
@Data
public class GetCoursesResponse {
    private List<CourseEntity> courses;
}
