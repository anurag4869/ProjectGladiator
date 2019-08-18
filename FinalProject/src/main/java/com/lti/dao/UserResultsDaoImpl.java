package com.lti.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.TableTest;
import com.lti.entity.TableUserResult;

@Repository
public class UserResultsDaoImpl implements UserResultsDao{
	
	@Autowired
	GenericDao dao;
	
	@Transactional
	public TableUserResult addToTableUserResults(int testId,Long count) {
		TableTest test=dao.fetchById(TableTest.class, testId);
		TableUserResult userResults=new TableUserResult();
		
		userResults.setTestUserResult(test);
		userResults.setScore(count.intValue());
		
		if(count.intValue()>=6) {
			userResults.setResultStatus("PASS");
			userResults.setLevelPassed(1);
		}
		else {
			userResults.setResultStatus("FAIL");
			userResults.setLevelPassed(1);
			}
		TableUserResult result=(TableUserResult)dao.save(userResults);
		System.out.println("UserResultId "+result.getUserResultId());
		return result;
		
		
	}

}
