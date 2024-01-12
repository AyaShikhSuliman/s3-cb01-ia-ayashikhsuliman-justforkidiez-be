package com.example.justyourkidiez.persistence;

import com.example.justyourkidiez.persistence.entity.Course.CoursesWithNumberOfLessonsEntity;
import com.example.justyourkidiez.persistence.entity.Lesson.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseLessonsRepository extends JpaRepository<LessonEntity, Long> {
//    @Query("SELECT new com.example.justyourkidiez.persistence.entity.Lesson.NumberOfLessonsPerCourseEntity(l.course, COUNT( l.id)) "
//            + "FROM LessonEntity AS l "
//            + "WHERE l.course.id=?1 "
//            + "GROUP BY l.course")
//    NumberOfLessonsPerCourseEntity getNumberOfLessonsPerCourse(long courseId);

//    SELECT c.id, c.image, c.title, c.description, COUNT(l.course_id) as "NumberOfLessons"
//    FROM just_your_kidiez.course as c inner join lesson as l
//    on c.id = l.course_id
//    group by l.course_id

    @Query("SELECT new com.example.justyourkidiez.persistence.entity.Course.CoursesWithNumberOfLessonsEntity(l.course, COUNT( l.id)) "
            + "FROM CourseEntity AS c " +
            "INNER JOIN  LessonEntity as l " +
            "ON c.id=l.course.id " +
            "GROUP BY l.course ")
    List<CoursesWithNumberOfLessonsEntity> getCoursesWithNumberOfLessons();

}
