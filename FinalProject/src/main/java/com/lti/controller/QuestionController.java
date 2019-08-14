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
import com.lti.service.QuestionServiceImpl;

@RestController
public class QuestionController {
	
	@Autowired
	private QuestionServiceImpl questionService;
	
	
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
	/*	TableSubject subject=dao.fetchById(TableSubject.class, subjectId);
		TableQuestion question=dao.fetchById(TableQuestion.class, questionId);
		
		question.setSubject(subject);
		dao.save(question);*/
		 subjectId=subject.getSubjectId();
		System.out.println("SubjectId "+subjectId);
		questionService.addQuestionForSubject(questionId,subjectId);
	
	}
	@PostMapping("/getAllQuestions.lti")
	public List<TableQuestion> displayAllQuestion(){
		List<TableQuestion>list=questionService.getAllQuestions();
		return list;
	}
	
	@GetMapping("/deleteQuestion.lti")
	public String assignProjectToEmployee(@RequestParam ("questionId") int questionId) {
		questionService.deleteQuestion(questionId);
	Status status=new Status();
	status.setMessage("Question deleted");
	return status.getMessage();

}
	
	
}
