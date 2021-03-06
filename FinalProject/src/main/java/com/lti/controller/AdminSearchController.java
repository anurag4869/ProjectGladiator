package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.TableStudent;
import com.lti.service.AdminService;

@RestController
public class AdminSearchController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping("/searchStudents.lti")
	public List<TableStudent> searchStudents(@RequestParam("subjectName") String subjectName,@RequestParam("studentState") String studentState, @RequestParam("studentCity") String studentCity
			,@RequestParam("levelPassed") int levelPassed, @RequestParam("score") int score) {
		List<TableStudent> listOfStudents=adminService.searchStudents(subjectName, studentState, studentCity, levelPassed, score);
		return listOfStudents;
	}
	
	
}
