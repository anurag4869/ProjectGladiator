package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.TableStudent;
import com.lti.service.StudentService;

@RestController
public class LoginController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/addStudent.lti")
	public void add(@RequestBody TableStudent student) {
		studentService.addStudent(student);
	}
/*	@PostMapping("/validateStudent.lti")
	public void validateLoginCredentials(@RequestBody String email, String password) {
		studentService.
	}*/
}


