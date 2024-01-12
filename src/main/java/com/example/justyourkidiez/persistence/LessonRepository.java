package com.example.justyourkidiez.persistence;

import com.example.justyourkidiez.persistence.entity.Lesson.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LessonRepository extends JpaRepository<LessonEntity, Long> {
    boolean existsByTitle(String title);

    @Query("select l.id, l.image, l.video, l.title, l.description from LessonEntity l where l.title LIKE %?1%")
    List<LessonEntity> getLessonsByOneLetterFromTitle(String titleLetter);


    List<LessonEntity> getLessonEntitiesByCourseId(Long courseId);


//    SELECT l.id, l.image, l.video, l.title, l.description, l.course_id, ls.status_name
//    FROM lesson as l
//    inner join lesson_status as ls
//    on l.id=ls.lesson_id
//    where l.course_id=2
    //getLessonsByCourseId

//    SELECT l.id, l.image, l.video, l.title, l.description, l.course_id, ls.status_name
//    FROM lesson as l
//    inner join lesson_status as ls
//    on l.id=ls.lesson_id
//    where l.course_id=2 AND ls.status_name="UNFINISHED"
    //getLessonByCourseIdAndUnfinished

//    SELECT l.id, l.image, l.video, l.title, l.description, l.course_id, ls.status_name
//    FROM lesson as l
//    inner join lesson_status as ls
//    on l.id=ls.lesson_id
//    where l.course_id=2 AND ls.status_name="FINISHED"
    //getLessonByCourseIdAndFinished
}
