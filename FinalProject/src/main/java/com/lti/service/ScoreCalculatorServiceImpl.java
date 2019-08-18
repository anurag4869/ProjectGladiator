package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ScoreCalculatorDao;
import com.lti.entity.TableUserResult;

@Service
public class ScoreCalculatorServiceImpl implements ScoreCalculatorService {
	
	@Autowired
	private ScoreCalculatorDao scoreCalculateDao;
	
	public TableUserResult calculateScore(int testId) {
		 return scoreCalculateDao.calculateScoreForUser(testId);
		
	}

}
