package com.studentenrollmentsystem.service.impl;

import com.studentenrollmentsystem.model.Enrollment;
import com.studentenrollmentsystem.repository.EnrollmentRepository;
import com.studentenrollmentsystem.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    @Transactional
    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public List<Enrollment> findAllCoursesOfStudent(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    @Override
    public List<Enrollment> findAllStudentsOfInstructor(Long instructorId) {
        return enrollmentRepository.findByCourseInstructorId(instructorId);
    }

    @Override
    public List<Enrollment> findAllEnrollments() {
        return enrollmentRepository.findAll();
    }
}
