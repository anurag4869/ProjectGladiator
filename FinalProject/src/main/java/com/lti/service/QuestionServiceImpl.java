package com.lti.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDaoImpl;
import com.lti.entity.TableQuestion;

@Service
public class QuestionServiceImpl {
	
	@Autowired
	private GenericDaoImpl dao;
	
	@Transactional
	public void addQuestion(TableQuestion question) {
	dao.save(question);
	}
}
