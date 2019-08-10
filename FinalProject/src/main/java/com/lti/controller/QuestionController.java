package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.TableQuestion;
import com.lti.service.QuestionServiceImpl;

@RestController
public class QuestionController {
	
	@Autowired
	private QuestionServiceImpl questionService;
	
	@PostMapping("/addQuestion.lti")
	public void addStudent(@RequestBody TableQuestion question) {
		questionService.addQuestion(question);
	}
}
