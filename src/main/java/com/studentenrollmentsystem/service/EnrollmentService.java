package com.studentenrollmentsystem.service;

import com.studentenrollmentsystem.model.Enrollment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EnrollmentService {
    @Transactional
    Enrollment saveEnrollment(Enrollment enrollment);

    List<Enrollment> findAllCoursesOfStudent(Long studentId);

    List<Enrollment> findAllStudentsOfInstructor(Long instructorId);

    List<Enrollment> findAllEnrollments();
}
