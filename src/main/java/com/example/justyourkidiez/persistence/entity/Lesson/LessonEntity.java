package com.example.justyourkidiez.persistence.entity.Lesson;

import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "lesson")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Length(min = 2 ,max = 1000)
    @Column(name = "image")
    private String image;

    @NotBlank
    @Length(min = 2 ,max = 1000)
    @Column(name = "video")
    private String video;

    @NotBlank
    @Length(min = 2 ,max = 50)
    @Column(name = "title")
    private String title;

    @NotBlank
    @Column(name = "description")
    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum lessonStatus;
}
