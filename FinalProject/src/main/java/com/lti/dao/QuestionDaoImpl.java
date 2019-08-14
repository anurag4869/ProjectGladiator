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
	static int questionNumber =0;

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Autowired
	GenericDaoImpl dao;
	
	public void addQuestionForExistingSubject( TableQuestion question) {
			dao.save(question);
		
	}
	

	public void deleteQuestion(int questionId) {
		
		TableQuestion question=dao.fetchById(TableQuestion.class, questionId);
		question.setQuestionStatus(0);
		dao.save(question);
		/*String query="Update table TableQuestion set questionStatus=0 where questionId=:questionId";
		Query q = entityManager.createQuery(query);
		q.setParameter("questionId", questionId);*/
		
	}
	
	

	
	public List<TableQuestion> fetchQuestionsById(int pk) {
		String q="select obj from TableQuestion obj where obj.subject.subjectId=:sid";
		Query query=entityManager.createQuery(q);
		query.setParameter("sid", pk);
		List<TableQuestion>list=query.getResultList();
		
	//	return entityManager.createQuery(q).getResultList();
		return list;
		
	}


}
