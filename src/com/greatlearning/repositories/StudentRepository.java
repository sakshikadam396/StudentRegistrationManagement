package com.greatlearning.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.library.entity.Book;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public List<Student> findByNameContainsAndCourseContainsAllIgnoreCase(String name, String course);

}

