package com.studentenrollmentsystem.controller;

import com.studentenrollmentsystem.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

    private EnrollmentService enrollmentService;

    @Autowired
    public ManagerController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping("/api/manager/enrollments")
    public ResponseEntity<?> findAllEnrollments() {
        return ResponseEntity.ok(enrollmentService.findAllEnrollments());
    }
}
