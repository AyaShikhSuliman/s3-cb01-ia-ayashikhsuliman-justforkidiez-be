package com.example.justyourkidiez.domain.Parent;

import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Parent {
    private Long id;
    private String name;
    private String last_name;
    private Long age;
    private String phone_number;
    private String email_address;
    private String country;
    private CourseEntity course;
}
