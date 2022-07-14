package com.greatlearning.library.service;

import java.util.List;

import com.greatlearning.library.entity.Book;

public interface StudentService {	
	public List<Student> findAll();
	public void save(Student s);
	public student findById(Integer id);
	public void delete(Student s);
	public List<Student> findByName_course(String name, String course);
}
