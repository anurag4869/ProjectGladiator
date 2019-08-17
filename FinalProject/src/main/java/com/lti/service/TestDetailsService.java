package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDaoImpl;
import com.lti.dao.TestDetailsDaoImpl;
import com.lti.entity.TableQuestion;
import com.lti.entity.TableTest;
import com.lti.entity.TableTestDetails;

@Service
public class TestDetailsService {
	@Autowired
	GenericDaoImpl dao;
	
	@Autowired
	TestDetailsDaoImpl testDetailsDao;
	
	@Transactional
	public void addToTableDetailsService(int testId,int questionId,String userResponse) {
		TableTest test=dao.fetchById(TableTest.class, testId);
		TableQuestion question=dao.fetchById(TableQuestion.class,questionId);
		
		TableTestDetails testDetails=new TableTestDetails();
		testDetails.setTestDetailsQuestion(question);
		testDetails.setTestDetailsTest(test);
		testDetails.setUserResponse(userResponse);
		String responseStatus=testDetailsDao.returnResponseStatus(questionId);
		if(responseStatus.equals(userResponse)) {responseStatus="CORRECT";}
		else {responseStatus="INCORRECT";}
		testDetails.setResponseStatus(responseStatus);
		
		dao.save(testDetails);
		
	}

}