package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entity.TableQuestion;

@Repository
public class QuestionDaoImpl {

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Autowired
	GenericDaoImpl dao;
	
	public void addQuestionForExistingSubject( TableQuestion question) {
			dao.save(question);
		
	}
	
	
	public List<TableQuestion> fetchQuestionsById(int pk) {
		String q="select obj from TableQuestion obj where obj.subject.subjectId=:sid";
		Query query=entityManager.createQuery(q);
		query.setParameter("sid", pk);
		List<TableQuestion>list=query.getResultList();
		return  list;
	//	return entityManager.createQuery(q).getResultList();
	}

}
