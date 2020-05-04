package com.studentenrollmentsystem.service.impl;

import com.studentenrollmentsystem.model.Course;
import com.studentenrollmentsystem.repository.CourseRepository;
import com.studentenrollmentsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public void deleteCourse(Long courseId) {
         courseRepository.deleteById(courseId);
    }

    @Override
    public List<Course> findAllCourses(){
        return courseRepository.findAll();
    }


}
