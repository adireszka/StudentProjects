package com.hogwart.gradebook.service;

import com.hogwart.gradebook.entity.Course;

import java.util.List;

public interface CourseService {
    Course getCourse(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
    List<Course> getCourses();
}
