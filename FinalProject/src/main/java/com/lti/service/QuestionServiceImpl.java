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
		question.setQuestionStatus(1);
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
	
	public List<TableQuestion> getAllQuestions(int subjectId){
		List<TableQuestion>list=questionDao.fetchAll(subjectId);
		return list;
	}
	
	@Transactional
	public void deleteQuestion(int questionId) {
	
		questionDao.deleteQuestion(questionId);
	}
	
	public List<Integer> getQuestionForStudent(int subjectId){
		List<Integer> listOfQuestionIds=questionDao.fetchQuestionsById(subjectId);
		return listOfQuestionIds;
		
	}
	
	public TableQuestion getASingleQuestionForStudent(int  questionId) {
	return dao.fetchById(TableQuestion.class, questionId);
		
	}
	
	
}
