package com.studentenrollmentsystem.controller;

import com.studentenrollmentsystem.model.User;
import com.studentenrollmentsystem.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TeacherController {

    private EnrollmentService enrollmentService;

    @Autowired
    public TeacherController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping("/api/teacher/students/{teacherId}")
    public ResponseEntity<?> findAllStudentsOfInstructor(@PathVariable Long teacherId){
        List<User> students = enrollmentService.findAllStudentsOfInstructor(teacherId).stream().map(enrollment -> enrollment.getStudent()).collect(Collectors.toList());
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
