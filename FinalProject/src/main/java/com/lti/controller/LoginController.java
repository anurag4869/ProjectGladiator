package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.service.AdminServiceImpl;
import com.lti.service.StudentServiceImpl;

@RestController
public class LoginController {

	@Autowired
	private StudentServiceImpl studentService;
	
	@Autowired
	private AdminServiceImpl adminService;

	
	@GetMapping("/validateStudentCredentials.lti")
	public String validateStudentLoginCredentials(@RequestParam("email") String email,@RequestParam("pwd") String pwd) {
		String value=studentService.validateStudentLoginCredentials(email, pwd);
		return value;
	}
	
	@GetMapping("/validateAdminCredentials.lti")
	public String validateAdminLoginCredentials(@RequestParam("email") String email,@RequestParam("pwd") String pwd) {
		String value=adminService.validateAdminLoginCredentials(email, pwd);
		
		return value;
	}
}


