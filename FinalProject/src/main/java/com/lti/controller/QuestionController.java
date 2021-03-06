package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.entity.TableQuestion;
import com.lti.entity.TableSubject;
import com.lti.service.QuestionService;

@RestController
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	
	int questionId;
	int subjectId;
	
	@PostMapping("/addQuestion.lti")
	public void addQuestion(@RequestBody TableQuestion question) {
		questionId=questionService.addQuestion(question);
		System.out.println("1.  Question Id "+questionId);
		Status status=new Status();
		status.setMessage("Question Added To Database");
		status.setGeneratedId(questionId);
		System.out.println("2. Question Id "+questionId);
		
	
	}
	@PostMapping("/addQuestionForSubject.lti")
	public void addQuestionForSubject(@RequestBody TableSubject subject) {

		 subjectId=subject.getSubjectId();
		System.out.println("SubjectId "+subjectId);
		questionService.addQuestionForSubject(questionId,subjectId);
	
	}
	@GetMapping("/getAllQuestions.lti")

	public List<TableQuestion> displayAllQuestion(@RequestParam("subjectId")int subjectId){

		List<TableQuestion>list=questionService.getAllQuestions(subjectId);
		return list;
	}
	
	@GetMapping("/deleteQuestion.lti")
	public String assignQuestionToSubject(@RequestParam ("questionId") int questionId) {
		questionService.deleteQuestion(questionId);
	Status status=new Status();
	status.setMessage("Question deleted");
	return status.getMessage();

}
	
	@PostMapping("/getSingleQuestion.lti")
	public TableQuestion getSingleQuestion(@RequestBody TableQuestion question) {
		question=questionService.getASingleQuestionForStudent(question.getQuestionId());
		return question;
	}
	
	
}
