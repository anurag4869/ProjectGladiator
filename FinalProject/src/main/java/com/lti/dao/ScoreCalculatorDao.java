package com.lti.dao;

import com.lti.entity.TableUserResult;

public interface ScoreCalculatorDao {
	public TableUserResult  calculateScoreForUser(int testId);
}
