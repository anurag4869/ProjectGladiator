package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.TableStudent; 

@Repository
public class StudentDaoImpl {
	
	@PersistenceContext
	protected EntityManager entityManager;

	public TableStudent validateStudentCredentials(String email, String pwd){
		TableStudent student=null;
		String query="select s from TableStudent s where studentEmail=:sEmail and studentPwd=:sPassword ";
	    Query q = entityManager.createQuery(query);
		q.setParameter("sEmail", email);
		q.setParameter("sPassword", pwd);
		try {
		student=(TableStudent)q.getSingleResult();
		return student;
		}
		catch(NoResultException e) {
			System.out.println("invalid");
		}
		return student;
	}
}
