package com.studentenrollmentsystem.repository;

import com.studentenrollmentsystem.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    //szukaj zapisow na kurs po id instruktora
    List<Enrollment> findByCourseInstructorId(Long instructorId);

    //szukaj zapisow po id studenta
    List<Enrollment> findByStudentId(Long studentId);
}
