package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.TableQuestion;
import com.lti.entity.TableSubject;
import com.lti.service.QuestionServiceImpl;

@RestController
public class displayQuestionForStudent {
	
	@Autowired QuestionServiceImpl questionService;
	
	@PostMapping("/displayQuestions.lti")
	public List<TableQuestion> displayQusetions(@RequestBody TableSubject subject) {
		List<TableQuestion> list=questionService.getQuestionForStudent(subject.getSubjectId());
		return list;
	}

}
