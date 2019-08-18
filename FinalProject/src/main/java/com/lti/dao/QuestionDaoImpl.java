package com.lti.dao;

import java.util.Collections;
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
	
	

	
	public List<Integer> fetchQuestionsById(int pk) {
		String q="select obj.questionId from TableQuestion obj where obj.subject.subjectId=:sid and obj.questionLevel=1 and obj.questionStatus=1";
		Query query=entityManager.createQuery(q);
		query.setParameter("sid", pk);
		List<Integer> listOfQuestionIds=query.getResultList();
		Collections.shuffle(listOfQuestionIds);
		
		return listOfQuestionIds.subList(0, 8);
	}
	public List<TableQuestion> fetchAll(int subjectId) {
		 String query="select question from TableQuestion question where question.questionStatus=:status and question.subject.subjectId=:subjectId";
		 Query q=entityManager.createQuery(query);
		 q.setParameter("subjectId", subjectId);
		 q.setParameter("status", 1);
		 List<TableQuestion> list=q.getResultList();
		 System.out.println("dao");
		 for(TableQuestion q1: list)
		  System.out.println(q1.getQuestion());
		 return list;
		}



}
