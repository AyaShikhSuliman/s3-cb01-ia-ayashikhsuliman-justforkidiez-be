package com.example.justyourkidiez.domain.Lesson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {
    private Long id;
    private String image;
    private String video;
    private String title;
    private String description;
    private Long courseId;
}
