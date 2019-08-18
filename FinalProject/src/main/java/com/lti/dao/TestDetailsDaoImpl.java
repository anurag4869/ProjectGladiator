package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.TableQuestion;

@Repository
public class TestDetailsDaoImpl implements TestDetailsDao {

	@PersistenceContext
	protected EntityManager entityManager;
	
	public String returnResponseStatus(int questionId) {
		String query="Select que from TableQuestion que where que.questionId=:questionId";
		Query q=entityManager.createQuery(query);
		q.setParameter("questionId", questionId);
		TableQuestion question=(TableQuestion)q.getSingleResult();
		return question.getCorrectAns();
		
	}
	
	
}
