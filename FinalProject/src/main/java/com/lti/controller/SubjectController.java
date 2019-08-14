package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dao.GenericDaoImpl;
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
	
	@PostMapping("/getAllSubjects.lti")
	public List<TableSubject> getAllSubjects(){
		List<TableSubject>list=subjectService.getAllSubjects();
		return list;
	}

}
