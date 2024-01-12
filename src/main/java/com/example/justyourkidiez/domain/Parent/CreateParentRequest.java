package com.example.justyourkidiez.domain.Parent;

import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateParentRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String last_name;
    @NotNull
    private Long age;
    @NotBlank
    private String phone_number;
    @NotBlank
    @Email
    private String email_address;
    @NotBlank
    private String country;
    @NotBlank
    private String password;
    private CourseEntity course;
}
