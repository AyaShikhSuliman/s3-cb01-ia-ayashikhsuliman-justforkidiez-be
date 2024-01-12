package com.example.justyourkidiez.business.impl.Coach;

import com.example.justyourkidiez.domain.Coach.Coach;
import com.example.justyourkidiez.persistence.entity.CoachEntity;

public class CoachConverter {
    private CoachConverter() {
    }

    public static Coach convert(CoachEntity parent) {
        return Coach.builder()
                .id(parent.getId())
                .name(parent.getName())
                .last_name(parent.getLast_name())
                .age(parent.getAge())
                .phone_number(parent.getPhone_number())
                .email_address(parent.getEmail_address())
                .build();
    }
}
