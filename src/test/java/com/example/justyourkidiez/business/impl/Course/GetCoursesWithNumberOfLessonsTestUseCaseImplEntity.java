package com.example.justyourkidiez.business.impl.Course;

import com.example.justyourkidiez.domain.Course.GetCoursesWithNumberOfLessonsResponse;
import com.example.justyourkidiez.persistence.CourseLessonsRepository;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import com.example.justyourkidiez.persistence.entity.Course.CoursesWithNumberOfLessonsEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetCoursesWithNumberOfLessonsTestUseCaseImplEntity {
    @Mock
    private CourseLessonsRepository courseLessonsRepository;

    @InjectMocks
    private GetCoursesWithNumberOfLessonUseCaseImpl getCoursesWithNumberOfLessonUseCase;

    @Test
    void getCoursesWithNumberOfLessons() {
        CourseEntity course = CourseEntity.builder()
                .id(1L)
                .image("https://static01.nyt.com/images/2019/07/01/well/01klass-sports/44aef00815ec40f4a49a6a229ddb4faf-superJumbo.jpg")
                .title("Sports")
                .description("Lets move a bit!")
                .build();
        List<CoursesWithNumberOfLessonsEntity> courseLessons = Collections.singletonList(new CoursesWithNumberOfLessonsEntity(course, 5));
        when(courseLessonsRepository.getCoursesWithNumberOfLessons()).thenReturn(courseLessons);

        GetCoursesWithNumberOfLessonsResponse response = getCoursesWithNumberOfLessonUseCase.getCoursesWithNumberOfLessons();

        verify(courseLessonsRepository).getCoursesWithNumberOfLessons();
        assertEquals(1, response.getNumberOfLessonsPerCourseEntities().size());
        CoursesWithNumberOfLessonsEntity result = response.getNumberOfLessonsPerCourseEntities().get(0);
        assertEquals(1, 1);
        assertEquals(5, result.getCount());
    }


    @Test
    void getCoursesWithNoNumberOfLessons() {
        List<CoursesWithNumberOfLessonsEntity> courseLessons = Collections.emptyList();
        when(courseLessonsRepository.getCoursesWithNumberOfLessons()).thenReturn(courseLessons);

        GetCoursesWithNumberOfLessonsResponse response = getCoursesWithNumberOfLessonUseCase.getCoursesWithNumberOfLessons();

        verify(courseLessonsRepository).getCoursesWithNumberOfLessons();
        assertEquals(0, response.getNumberOfLessonsPerCourseEntities().size());
    }
}

