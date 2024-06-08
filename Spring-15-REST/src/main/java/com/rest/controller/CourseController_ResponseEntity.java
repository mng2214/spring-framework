package com.rest.controller;

import com.rest.dto.CourseDTO;
import com.rest.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v2")
public class CourseController_ResponseEntity {

    private final CourseService courseService;

    public CourseController_ResponseEntity(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version","v2")
                .header("Operation","Get List Of Courses")
                .header("Content-Type","application/json")
                .body(courseService.getCourses());
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable int id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Version","v2")
                .body(courseService.getCourseById(id));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Operation","Create")
                .body(courseService.createCourse(courseDTO));
    }

}
