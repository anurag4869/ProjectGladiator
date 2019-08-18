package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.QuestionsDTO;
import com.lti.service.QuestionService;

@RestController
public class DisplayQuestionForStudentController {
	

	@Autowired
	QuestionService questionService;

	
	@PostMapping("/displayQuestionIdsUsingDto.lti")
	public List<Integer> displayQuestionsList(@RequestBody QuestionsDTO dto){
		List<Integer> listOfQuestionIds=questionService.getQuestionForStudent(dto.getSubjectId());	
		return listOfQuestionIds;
	}

}
