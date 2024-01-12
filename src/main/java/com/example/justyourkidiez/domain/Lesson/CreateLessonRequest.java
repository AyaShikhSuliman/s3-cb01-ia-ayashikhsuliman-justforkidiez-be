package com.example.justyourkidiez.domain.Lesson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateLessonRequest {
    @NotBlank
    private String image;
    @NotBlank
    private String video;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    private Long courseId;
}
