package com.studentenrollmentsystem.controller;

import com.studentenrollmentsystem.model.Enrollment;
import com.studentenrollmentsystem.model.Role;
import com.studentenrollmentsystem.model.User;
import com.studentenrollmentsystem.service.CourseService;
import com.studentenrollmentsystem.service.EnrollmentService;
import com.studentenrollmentsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    private UserService userService;
    private CourseService courseService;
    private EnrollmentService enrollmentService;

    @Autowired
    public UserController(UserService userService, CourseService courseService, EnrollmentService enrollmentService) {
        this.userService = userService;
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
    }

    @PostMapping("/api/user/registration")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()) != null)
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        user.setRole(Role.STUDENT);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/api/user/login")
    public ResponseEntity<?> getUser(Principal principal) {
        if (principal == null) {
            //for logout
            return ResponseEntity.ok(principal);
        }
        return new ResponseEntity<>(userService.findByUsername(principal.getName()), HttpStatus.OK);
    }

    @PostMapping("/api/user/enroll")
    public ResponseEntity<?> enrollCourse(@RequestBody Enrollment enrollment) {
        return new ResponseEntity<>(enrollmentService.saveEnrollment(enrollment), HttpStatus.CREATED);
    }

    @GetMapping("/api/user/courses")
    public ResponseEntity<?> getCourses() {
        return ResponseEntity.ok(courseService.findAllCourses());
    }

}
