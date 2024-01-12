package com.example.justyourkidiez.persistence;

import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    boolean existsByTitle(String title);

    CourseEntity findCourseEntityById(Long courId);

    @Query("select course.id from CourseEntity course where course.title = ?1")
    Long getCourseByTitle(String title);

    @Query("select c.id, c.image, c.title, c.description from CourseEntity c where c.title LIKE %?1%")
    List<CourseEntity> getCoursesByOneLetterFromTitle(String titleLetter);
}
