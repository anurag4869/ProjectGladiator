package com.lti.ui;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lti.dao.GenericDaoImpl;
import com.lti.entity.TableQuestion;
import com.lti.entity.TableSubject;
import com.lti.service.SubjectServiceImpl;

public class QuestionTest {

	@Autowired
	GenericDaoImpl dao;
	
	@Autowired
	SubjectServiceImpl subjectService;
	
	@Test
	public void addSubject() {
		TableSubject subject=new TableSubject();
		System.out.println("hey");
	
		subject.setSubjectName("PHP");
	
		subjectService.addSubject(subject);
		
		
	}
	
	@Test
	public void addQuestionWithSubject()
	{
		
		TableSubject subject=(TableSubject)dao.fetchById(TableSubject.class,2);
		
		TableQuestion question=new TableQuestion();
		question.setQuestion("In what field is C++ better than Java?");
		question.setChoiceOne("Platform Independence");
		question.setChoiceTwo("Robustness");
		question.setChoiceThree("Speed");
		question.setChoiceFour("Object oriented");
		question.setQuestionLevel(1);
		question.setSubject(subject);
		question.setCorrectAns("choice1");

		
	}
}
