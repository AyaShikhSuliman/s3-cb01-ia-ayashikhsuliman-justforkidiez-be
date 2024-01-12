package com.example.justyourkidiez.domain.Coach;

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
public class CreateCoachRequest {
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
    @Length(max = 50)
    private String password;
}
