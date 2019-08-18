package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entity.TableUserResult;

@Repository
public class ScoreCalculatorDaoImpl implements ScoreCalculatorDao {
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Autowired
	private UserResultsDao userResultDao;
	
	public TableUserResult  calculateScoreForUser(int testId) {
		String q="Select count(*) from TableTestDetails td where td.testDetailsTest.testId=:testId and td.responseStatus='CORRECT'";
		Query query=entityManager.createQuery(q);
		query.setParameter("testId",testId);
		Long count = (Long)query.getSingleResult();
		System.out.println("COUNT " +count);
		return userResultDao.addToTableUserResults( testId, count);
	
		
		
	}
	
	
	
}
