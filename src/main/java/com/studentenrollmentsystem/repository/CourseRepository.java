package com.studentenrollmentsystem.repository;

import com.studentenrollmentsystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
