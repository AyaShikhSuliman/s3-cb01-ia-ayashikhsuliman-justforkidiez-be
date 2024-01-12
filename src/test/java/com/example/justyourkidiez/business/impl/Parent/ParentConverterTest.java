package com.example.justyourkidiez.business.impl.Parent;

import com.example.justyourkidiez.domain.Parent.Parent;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import com.example.justyourkidiez.persistence.entity.ParentEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ParentConverterTest {
    @Mock
    private ParentEntity parentEntity;

    @InjectMocks
    private ParentConverter parentConverter;

    @Test
    public void convert() {
        when(parentEntity.getId()).thenReturn(1L);
        when(parentEntity.getName()).thenReturn("John");
        when(parentEntity.getLast_name()).thenReturn("Doe");
        when(parentEntity.getAge()).thenReturn(30L);
        when(parentEntity.getPhone_number()).thenReturn("123456789");
        when(parentEntity.getEmail_address()).thenReturn("john.doe@example.com");
        when(parentEntity.getCountry()).thenReturn("USA");
        when(parentEntity.getCourse()).thenReturn(CourseEntity.builder().build());

        Parent convertedParent = ParentConverter.convert(parentEntity);

        Assertions.assertEquals(1L, convertedParent.getId());
        Assertions.assertEquals("John", convertedParent.getName());
        Assertions.assertEquals("Doe", convertedParent.getLast_name());
        Assertions.assertEquals(30, convertedParent.getAge());
        Assertions.assertEquals("123456789", convertedParent.getPhone_number());
        Assertions.assertEquals("john.doe@example.com", convertedParent.getEmail_address());
        Assertions.assertEquals("USA", convertedParent.getCountry());
        Assertions.assertEquals(CourseEntity.builder().build(), convertedParent.getCourse());
    }
}

