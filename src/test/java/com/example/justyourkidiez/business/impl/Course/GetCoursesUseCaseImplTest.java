package com.example.justyourkidiez.business.impl.Course;

import com.example.justyourkidiez.domain.Course.Course;
import com.example.justyourkidiez.domain.Course.GetCoursesResponse;
import com.example.justyourkidiez.persistence.CourseRepository;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class GetCoursesUseCaseImplTest {
    @Mock
    private CourseRepository courseRepositoryMock;

    @InjectMocks
    private GetCoursesUseCaseImpl getCoursesUseCase;

    @Test
    void getCourses() {
        CourseEntity languagesEntity = CourseEntity.builder().id(1L).image("https://static01.nyt.com/images/2019/07/01/well/01klass-sports/44aef00815ec40f4a49a6a229ddb4faf-superJumbo.jpg").title("Languages").description("Lets learn a bit!").build();
        CourseEntity sportsEntity = CourseEntity.builder().id(2L).image("https://static01.nyt.com/images/2019/07/01/well/01klass-sports/44aef00815ec40f4a49a6a229ddb4faf-superJumbo.jpg").title("Sports").description("Lets move a bit!").build();

        when(courseRepositoryMock.findAll())
                .thenReturn(List.of(languagesEntity, sportsEntity));

        GetCoursesResponse actualResult = getCoursesUseCase.getCourses();

        CourseEntity languages = CourseEntity.builder().id(1L).image("https://static01.nyt.com/images/2019/07/01/well/01klass-sports/44aef00815ec40f4a49a6a229ddb4faf-superJumbo.jpg").title("Languages").description("Lets learn a bit!").build();
        CourseEntity sports = CourseEntity.builder().id(2L).image("https://static01.nyt.com/images/2019/07/01/well/01klass-sports/44aef00815ec40f4a49a6a229ddb4faf-superJumbo.jpg").title("Sports").description("Lets move a bit!").build();

        GetCoursesResponse expectedResult = GetCoursesResponse
                .builder()
                .courses(List.of(languages, sports))
                .build();

        assertEquals(expectedResult, actualResult);

        verify(courseRepositoryMock).findAll();
    }
}


