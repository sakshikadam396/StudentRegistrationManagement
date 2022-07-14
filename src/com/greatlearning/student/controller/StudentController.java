package com.greatlearning.library.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.library.entity.Student;
import com.greatlearning.library.service.StudentService;


@Controller
@RequestMapping("/students")
public class StudentsController {
	

	@Autowired
	private StudentService studentService;



	// add mapping for "/list"

	@RequestMapping("/list")
	public String listStudents(Model theModel) {
		

		// get Books from db
		List<Book> theStudents = studentService.findAll();

		// add to the spring model
		theModel.addAttribute("students", theStudents);
		return "Students";
	}

	@RequestMapping("/addStudent")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Student theStudent = new Student();

		theModel.addAttribute("student", theStudent);

		return "studentForm";
	}

	
	@RequestMapping("/updateStudent")
	public String showFormForUpdate(@RequestParam("studentId") Integer theId,
			Model theModel) {

		// get the Book from the service
		Student thestudent = studentService.findById(theId);


		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("student", thestudent);

		// send over to our form
		return "StudentForm";			
	}


	@PostMapping("/save")
	public String saveBook(@RequestParam("id") Integer id,
			@RequestParam("name") String name,@RequestParam("course") String category,@RequestParam("country") String author) {

		System.out.println(id);
		Book theStudent;
		if(id!=0)
		{
			theStudent=studentService.findById(id);
			theStudent.setName(name);
			theStudent.setCourse(course);
			theStudent.setCourse(country);
		}
		else
			theStudent=new Student(name, course, country);
		// save the Student
		studentService.save(theStudent);


		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";

	}

	

	@RequestMapping("/deleteStudent")
	public String delete(@RequestParam("studentId") Integer theId) {

		if(theId!=0)
		{
			Book theStudent=studentService.findById(theId);
			studentService.delete(theStudent);
		}
		
		// redirect to /Students/list
		return "redirect:/students/list";

	}


	@RequestMapping("/search")
	public String search(@RequestParam("name") String name,
			@RequestParam("course") String course,
			Model theModel) {

		// check names, if both are empty then just give list of all Books
		if (name.trim().isEmpty() && course.trim().isEmpty()) {
			return "redirect:/students/list";
		}
		else {
			// else, search by name and last name
			List<Student> theStudents =studentService.findByName_Course(name, course);

			// add to the spring model
			theModel.addAttribute("Students", theStudents);

			// send to list-Students
			return "Students";
		}
	}
	
	@RequestMapping("/403")
	public ModelAndView accessDenied(Principal user)
	{
		ModelAndView mv=new ModelAndView();
		
		if(user!=null)
		{
			mv.addObject("msg", "Hi "+user.getName()+", you are not allowed to access this page");			
		}
		else
		{
			mv.addObject("msg", "Hi, you are not allowed to access this page");	
		}
		mv.setViewName("403");
		return mv;
	}

}
