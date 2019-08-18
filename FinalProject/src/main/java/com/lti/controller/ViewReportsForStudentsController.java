package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.TableUserResult;
import com.lti.service.ViewReportsStudentServiceImpl;

@RestController
public class ViewReportsForStudentsController {
	
	@Autowired
	ViewReportsStudentServiceImpl reportsService;

	@GetMapping("/viewReports.lti")
	public List<Object[]> viewReports(@RequestParam("studentId") int studentId) {
		List<Object[]> list=reportsService.viewReports(studentId);
		return list;
	}

}
