package com.example.justyourkidiez.domain.Coach;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coach {
    private Long id;
    private String name;
    private String last_name;
    private Long age;
    private String phone_number;
    private String email_address;
}
