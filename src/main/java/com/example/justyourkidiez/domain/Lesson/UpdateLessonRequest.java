package com.example.justyourkidiez.domain.Lesson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLessonRequest {
    private Long id;
    private String image;
    private String video;
    private String description;
    private String lessonStatus;
    private long courseId;
}
