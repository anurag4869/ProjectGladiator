package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entity.TableQuestion;
import com.lti.entity.TableSubject;

@Repository
public class QuestionDaoImpl {

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Autowired
	GenericDaoImpl dao;
	
	public void addQuestionForExistingSubject( TableQuestion question) {
		
	
		dao.save(question);
		
	}
	
	public void deleteQuestion(int questionId) {
		
		TableQuestion question=dao.fetchById(TableQuestion.class, questionId);
		question.setQuestionStatus(0);
		dao.save(question);
		/*String query="Update table TableQuestion set questionStatus=0 where questionId=:questionId";
		Query q = entityManager.createQuery(query);
		q.setParameter("questionId", questionId);*/
		
	}
	
	
}
