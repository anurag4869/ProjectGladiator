package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ScoreCalculatorDaoImpl;
import com.lti.entity.TableUserResult;

@Service
public class ScoreCalculatorServiceImpl {
	@Autowired
	private ScoreCalculatorDaoImpl scoreCalculateDao;
	
	public TableUserResult calculateScore(int testId) {
		 return scoreCalculateDao.calculateScoreForUser(testId);
		
	}

}
