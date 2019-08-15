package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDaoImpl;
import com.lti.entity.TableQuestion;
import com.lti.entity.TableTest;
import com.lti.entity.TableTestDetails;

@Service
public class TestDetailsService {
	@Autowired
	GenericDaoImpl dao;
	
	@Transactional
	public void addToTableDetailsService(int testId,int questionId,String userResponse) {
		TableTest test=dao.fetchById(TableTest.class, testId);
		TableQuestion question=dao.fetchById(TableQuestion.class,questionId);
		
		TableTestDetails testDetails=new TableTestDetails();
		testDetails.setTestDetailsQuestion(question);
		testDetails.setTestDetailsTest(test);
		testDetails.setUserResponse(userResponse);
		testDetails.setResponseStatus(userResponse);
		
		dao.save(testDetails);
		
	}

}
