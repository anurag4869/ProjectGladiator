package com.lti.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDaoImpl;
import com.lti.dao.QuestionDaoImpl;
import com.lti.entity.TableQuestion;
import com.lti.entity.TableSubject;

@Service
public class QuestionServiceImpl {
	
	@Autowired
	private GenericDaoImpl dao;
	
	@Autowired
	private QuestionDaoImpl questionDao;
	
	@Transactional
	public int addQuestion(TableQuestion question) {
		TableQuestion questionDetails=(TableQuestion)dao.save(question);
		System.out.println("1. Service "+questionDetails.getQuestionId());
		return questionDetails.getQuestionId();
		
	}
	
	@Transactional
	public void addQuestionForSubject( int questionId,int subjectId) {
		/*TableQuestion updatedQuestion=(TableQuestion) dao.save(question);
		return updatedQuestion.getQuestionId();*/
		TableSubject subject=dao.fetchById(TableSubject.class, subjectId);
		TableQuestion question=dao.fetchById(TableQuestion.class, questionId);
		
		question.setSubject(subject);
		dao.save(question);
		}
	
	public List<TableQuestion> getAllQuestions(){
		List<TableQuestion>list=dao.fetchAll(TableQuestion.class);
		return list;
	}
	
	@Transactional
	public void deleteQuestion(int questionId) {
	
		dao.delete(TableQuestion.class, questionId);
	}
	
	public List<TableQuestion> getQuestionForStudent(int subjectId){
		List<TableQuestion> list=questionDao.fetchQuestionsById(subjectId);
		return list;
		
	}
	
	
	
}
