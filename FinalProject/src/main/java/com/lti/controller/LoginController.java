package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.service.AdminService;
import com.lti.service.StudentService;

@RestController
public class LoginController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private AdminService adminService;

	
	@GetMapping("/validateStudentCredentials.lti")
	public Status validateStudentLoginCredentials(@RequestParam("email") String email,@RequestParam("pwd") String pwd) {
		
		Status status = new Status();
		status=studentService.validateStudentLoginCredentials(email, pwd);
		
		return status;
	}
	
	@GetMapping("/validateAdminCredentials.lti")
	public Status validateAdminLoginCredentials(@RequestParam("email") String email,@RequestParam("pwd") String pwd) {

		Status status=new Status();
		status = adminService.validateAdminLoginCredentials(email, pwd);
		
		return status;
	}
}


