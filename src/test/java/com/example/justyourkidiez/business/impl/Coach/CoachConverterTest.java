package com.example.justyourkidiez.business.impl.Coach;

import com.example.justyourkidiez.domain.Coach.Coach;
import com.example.justyourkidiez.persistence.entity.CoachEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CoachConverterTest {
    @Test
    public void convert() {
        CoachEntity coachEntity = new CoachEntity();
        coachEntity.setId(1L);
        coachEntity.setName("John");
        coachEntity.setLast_name("Doe");
        coachEntity.setAge(30L);
        coachEntity.setPhone_number("1234567890");
        coachEntity.setEmail_address("john.doe@example.com");

        Coach coach = CoachConverter.convert(coachEntity);

        Assertions.assertNotNull(coach);
        Assertions.assertEquals(coachEntity.getId(), coach.getId());
        Assertions.assertEquals(coachEntity.getName(), coach.getName());
        Assertions.assertEquals(coachEntity.getLast_name(), coach.getLast_name());
        Assertions.assertEquals(coachEntity.getAge(), coach.getAge());
        Assertions.assertEquals(coachEntity.getPhone_number(), coach.getPhone_number());
        Assertions.assertEquals(coachEntity.getEmail_address(), coach.getEmail_address());
    }
}


