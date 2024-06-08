package com.rest.controller;

import com.rest.entity.ResponseWrapper;
import com.rest.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses/api/v3")
public class CourseController_ResponseWrapper {

    private final CourseService courseService;

    public CourseController_ResponseWrapper(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getCourses() {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("version", "v3")
                .body(new ResponseWrapper("successfully retrieved all data", courseService.getCourses()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper> getCoursesById(@PathVariable int id) {
        return ResponseEntity.ok(new ResponseWrapper("successfully retrieved data course " + id, courseService.getCourseById(id)));
    }
}
