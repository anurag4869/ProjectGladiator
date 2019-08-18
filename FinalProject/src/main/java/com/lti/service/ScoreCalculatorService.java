package com.lti.service;

import com.lti.entity.TableUserResult;

public interface ScoreCalculatorService {
	public TableUserResult calculateScore(int testId);
}
