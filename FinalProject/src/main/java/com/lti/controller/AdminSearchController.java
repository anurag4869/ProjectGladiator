package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.TableStudent;
import com.lti.service.AdminServiceImpl;

@RestController
public class AdminSearchController {

	@Autowired
	private AdminServiceImpl adminService;
	
	@GetMapping("/searchStudents.lti")
	public List<TableStudent> searchStudents(@RequestParam("subjectName") String subjectName,@RequestParam("studentState") String studentState, @RequestParam("studentCity") String studentCity
			,@RequestParam("questionLevel") int questionLevel, @RequestParam("score") int score) {
		List<TableStudent> listOfStudents=adminService.searchStudents(subjectName, studentState, studentCity, questionLevel, score);
		return listOfStudents;
	}
	
	
}
