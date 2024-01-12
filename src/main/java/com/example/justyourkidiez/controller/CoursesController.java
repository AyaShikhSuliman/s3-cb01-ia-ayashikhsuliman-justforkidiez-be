package com.example.justyourkidiez.controller;

import com.example.justyourkidiez.business.UseCases.Course.*;
import com.example.justyourkidiez.domain.Course.*;
import com.example.justyourkidiez.persistence.entity.Course.CourseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class CoursesController {
    private final CreateCourseUseCase createCourseUseCase;
    private final GetCoursesUseCase getCoursesUseCase;
    private final UpdateCourseUseCase updateCourseUseCase;
    private final DeleteCourseUseCase deleteCourseUseCase;
    private final GetCourseUseCase getCourseUseCase;
    private final GetCoursesWithNumberOfLessonsUseCase getCoursesWithNumberOfLessonsUseCase;

    @GetMapping
    @ReadOnlyProperty
    public ResponseEntity<GetCoursesResponse> getCourses() {
        return ResponseEntity.ok(getCoursesUseCase.getCourses());
    }

    @GetMapping("/coursesWithNumber")
    @ReadOnlyProperty
    public ResponseEntity<GetCoursesWithNumberOfLessonsResponse> getCoursesWithNumberOfLessons() {
        return ResponseEntity.ok(getCoursesWithNumberOfLessonsUseCase.getCoursesWithNumberOfLessons());
    }

    @PostMapping()
//    @IsAuthenticated
//    @RolesAllowed({"ROLE_COACH"})
    public ResponseEntity<CreateCourseResponse> createCourse(@RequestBody @Valid CreateCourseRequest request) {
        CreateCourseResponse response = createCourseUseCase.createCourse(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("{courseId}")
//    @IsAuthenticated
//    @RolesAllowed({"ROLE_COACH"})
    public ResponseEntity<Void> deleteCourse(@PathVariable int courseId) {
        deleteCourseUseCase.deleteCourse(courseId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
//    @IsAuthenticated
//    @RolesAllowed({"ROLE_COACH"})
    public ResponseEntity<Void> updateCourse(@PathVariable("id") long id, @RequestBody @Valid UpdateCourseRequest request) {
        request.setId(id);
        updateCourseUseCase.updateCourse(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
//    @IsAuthenticated
//    @RolesAllowed({"ROLE_COACH"})
    public ResponseEntity<CourseEntity> getCourse(@PathVariable(value = "id") final long id) {
        final Optional<CourseEntity> courseOptional = getCourseUseCase.getCourse(id);
        if (courseOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(courseOptional.get());
    }
}
