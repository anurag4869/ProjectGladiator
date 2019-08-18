package com.lti.dao;

import com.lti.entity.TableUserResult;

public interface UserResultsDao {
	public TableUserResult addToTableUserResults(int testId,Long count);
}
