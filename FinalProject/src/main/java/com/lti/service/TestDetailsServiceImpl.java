package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDao;
import com.lti.dao.TestDetailsDao;
import com.lti.entity.TableQuestion;
import com.lti.entity.TableTest;
import com.lti.entity.TableTestDetails;

@Service
public class TestDetailsServiceImpl implements TestDetailsService{
	@Autowired
	GenericDao dao;
	
	@Autowired
	TestDetailsDao testDetailsDao;
	
	@Transactional
	public void addToTableDetailsService(int testId,int questionId,String userResponse) {
		TableTest test=dao.fetchById(TableTest.class, testId);
		TableQuestion question=dao.fetchById(TableQuestion.class,questionId);
		
		TableTestDetails testDetails=new TableTestDetails();
		testDetails.setTestDetailsQuestion(question);
		testDetails.setTestDetailsTest(test);
		testDetails.setUserResponse(userResponse);
		String responseStatus=testDetailsDao.returnResponseStatus(questionId);
		if(responseStatus.equalsIgnoreCase(userResponse)) {responseStatus="CORRECT";}
		else {responseStatus="INCORRECT";}
		testDetails.setResponseStatus(responseStatus);
		
		dao.save(testDetails);
		
	}

}
