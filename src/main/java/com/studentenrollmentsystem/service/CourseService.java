package com.studentenrollmentsystem.service;

import com.studentenrollmentsystem.model.Course;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CourseService {
    @Transactional
    Course addCourse(Course course);

    @Transactional
    Course updateCourse(Course course);

    @Transactional
    void deleteCourse(Long courseId);

    List<Course> findAllCourses();
}
