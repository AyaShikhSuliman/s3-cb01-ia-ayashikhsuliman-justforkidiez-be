package com.example.justyourkidiez.domain.Parent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateParentRequest {
    private Long id;
    @NotBlank
    private String name;

    @NotNull
    private Long courseId;
}
