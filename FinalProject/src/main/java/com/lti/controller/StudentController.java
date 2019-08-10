package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.TableStudent;
import com.lti.service.StudentServiceImpl;

@RestController
public class StudentController {

	@Autowired
	private StudentServiceImpl studentService;

	@PostMapping("/addStudent.lti")
	public void addStudent(@RequestBody TableStudent student) {
		studentService.addStudent(student);
	}
}