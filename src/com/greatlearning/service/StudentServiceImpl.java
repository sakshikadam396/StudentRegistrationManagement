package com.greatlearning.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Student;
import com.greatlearning.library.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<Students> findAll() {
		return studentRepo.findAll();
	}

	@Override
	public void save(Student student) {
		studentRepo.save(student);	
	}

	@Override
	public Student findById(Integer id) {
		return studentRepo.findById(id).get();
	}

	@Override
	public void delete(Student student) {
		studentRepo.delete(student);		
	}

	@Override
	public List<Student> findByName_course(String name, String course) {
		return studentRepo.findByNameContainsAndCourseContainsAllIgnoreCase(name, course);
	}

}

