package com.hogwart.gradebook.repository;

import com.hogwart.gradebook.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
