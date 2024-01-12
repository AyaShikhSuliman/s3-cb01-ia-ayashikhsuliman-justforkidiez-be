package com.example.justyourkidiez.domain.Course;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCourseRequest {
   @NotBlank
   private String image;
   @NotBlank
   @Length(min = 2)
   private String title;
   @NotBlank
   @Length(min = 2)
   private String description;
}
