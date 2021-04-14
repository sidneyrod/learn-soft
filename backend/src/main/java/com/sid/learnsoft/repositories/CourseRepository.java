package com.sid.learnsoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.learnsoft.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
