package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.TableSubject;
import com.lti.service.SubjectServiceImpl;

@RestController
public class SubjectController {
	@Autowired
	SubjectServiceImpl subjectService;
	
	@PostMapping("/addSubject.lti")
	public void addSubject(@RequestBody TableSubject subject) {
		subjectService.addSubject(subject);
	}

}
