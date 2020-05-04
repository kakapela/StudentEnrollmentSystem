package com.studentenrollmentsystem.controller;

import com.studentenrollmentsystem.model.Course;
import com.studentenrollmentsystem.model.Enrollment;
import com.studentenrollmentsystem.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    private EnrollmentService enrollmentService;

    @Autowired
    public StudentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }


    @GetMapping("/api/student/courses/{studentId}")
    public ResponseEntity<?> findAllCoursesofStudent(@PathVariable Long studentId){

        List<Course> courseList = enrollmentService.findAllCoursesOfStudent(studentId).stream().map(enrollment -> enrollment.getCourse()).collect(Collectors.toList());
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }

    @PostMapping("/api/student/enroll")
    public ResponseEntity<?> enroll(@RequestBody Enrollment enrollment) {
        return new ResponseEntity<>(enrollmentService.saveEnrollment(enrollment), HttpStatus.CREATED);
    }

}
