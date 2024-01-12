package com.example.justyourkidiez.business.impl.Parent;

import com.example.justyourkidiez.domain.Parent.Parent;
import com.example.justyourkidiez.persistence.entity.ParentEntity;

public class ParentConverter {
    private ParentConverter() {
    }

    public static Parent convert(ParentEntity parent) {
        return Parent.builder()
                .id(parent.getId())
                .name(parent.getName())
                .last_name(parent.getLast_name())
                .age(parent.getAge())
                .phone_number(parent.getPhone_number())
                .email_address(parent.getEmail_address())
                .country(parent.getCountry())
                .course(parent.getCourse())
                .build();
    }
}
