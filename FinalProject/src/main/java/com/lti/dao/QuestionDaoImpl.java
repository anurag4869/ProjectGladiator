package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entity.TableQuestion;
import com.lti.entity.TableSubject;

@Repository
public class QuestionDaoImpl {

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Autowired
	GenericDaoImpl dao;
	
	public void addQuestionForExistingSubject( TableQuestion question) {
		
	
		dao.save(question);
		
	}
}
