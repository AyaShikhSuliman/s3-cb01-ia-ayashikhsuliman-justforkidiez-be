package com.example.justyourkidiez.controller;

import com.example.justyourkidiez.business.UseCases.Lesson.*;
import com.example.justyourkidiez.domain.Lesson.CreateLessonRequest;
import com.example.justyourkidiez.domain.Lesson.CreateLessonResponse;
import com.example.justyourkidiez.domain.Lesson.GetLessonsResponse;
import com.example.justyourkidiez.domain.Lesson.UpdateLessonRequest;
import com.example.justyourkidiez.persistence.entity.Lesson.LessonEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/lessons")
@CrossOrigin(origins = {"http://localhost:3000"})
@RequiredArgsConstructor
public class LessonsController {
    private final CreateLessonUseCase createLessonUseCase;
    private final GetLessonsUseCase getLessonsUseCase;
    private final UpdateLessonUseCase updateLessonUseCase;
    private final DeleteLessonUseCase deleteLessonUseCase;
    private final GetLessonUseCase getLessonUseCase;

    @GetMapping
//    @IsAuthenticated
//    @RolesAllowed({"ROLE_COACH"})
    public ResponseEntity<GetLessonsResponse> getLessons() {
        return ResponseEntity.ok(getLessonsUseCase.getLessons());
    }

    @GetMapping("{id}")
//    @IsAuthenticated
//    @RolesAllowed({"ROLE_PARENT", "ROLE_COACH"})
    public ResponseEntity<LessonEntity> getLesson(@PathVariable(value = "id") final long id) {
        final Optional<LessonEntity> lessonOptional = getLessonUseCase.getLesson(id);
        if (lessonOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(lessonOptional.get());
    }

    @GetMapping("/lesson/{courseId}")
//    @IsAuthenticated
//    @RolesAllowed({"ROLE_PARENT", "ROLE_COACH"})
    @Transactional(readOnly = true)
    public ResponseEntity<GetLessonsResponse> getLessonEntitiesByCourseId(@PathVariable long courseId) {
        GetLessonsResponse response = getLessonsUseCase.getLessonEntitiesByCourseId(courseId);
        return ResponseEntity.ok(response);
    }

    @PostMapping()
//    @IsAuthenticated
//    @RolesAllowed({"ROLE_COACH"})
    public ResponseEntity<CreateLessonResponse> createLesson(@RequestBody @Valid CreateLessonRequest request) {
        CreateLessonResponse response = createLessonUseCase.createLesson(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @DeleteMapping("{lessonId}")
//    @IsAuthenticated
//    @RolesAllowed({"ROLE_COACH"})
    public ResponseEntity<Void> deleteLesson(@PathVariable int lessonId) {
        deleteLessonUseCase.deleteLesson(lessonId);
        return ResponseEntity.noContent().build();
    }


//    @IsAuthenticated
//    @RolesAllowed({"ROLE_PARENT", "ROLE_COACH"})
    @PutMapping("{id}")
    public ResponseEntity<Void> updateLesson(@PathVariable("id") long id, @RequestBody @Valid UpdateLessonRequest request) {
        request.setId(id);
        updateLessonUseCase.updateLesson(request);
        return ResponseEntity.noContent().build();
    }
}
