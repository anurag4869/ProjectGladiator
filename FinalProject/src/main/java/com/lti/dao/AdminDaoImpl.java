package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.TableAdmin;
import com.lti.entity.TableStudent;

@Repository
public class AdminDaoImpl {
	@PersistenceContext
	protected EntityManager entityManager;

	public TableAdmin validateAdminCredentials(String email, String pwd){
		TableAdmin admin=null;
		String query="select a from TableAdmin a where adminEmail=:aEmail and adminPwd=:aPassword ";
	    Query q = entityManager.createQuery(query);
		q.setParameter("aEmail", email);
		q.setParameter("aPassword", pwd);
		try {
		admin=(TableAdmin)q.getSingleResult();
		return admin;
		}
		catch(NoResultException e) {
			
		}
		return admin;
		
		
		
	}
	
	public List<TableStudent> searchStudents(String subjectName,String studentState,String studentCity,int levelPassed, int score){
	
	
		
		String query=" select stud from TableStudent as stud join stud.testStudents as ts join ts.testSubject as sub join ts.testResult as result where "+
		"sub.subjectName = :subjectName and stud.studentCity = :studentCity and stud.studentState = :studentState and result.levelPassed = :levelPassed " +
				"and result.score = :score";
		
	    Query q = entityManager.createQuery(query);
	    q.setParameter("studentCity", studentCity);
	    q.setParameter("studentState", studentState);
	    q.setParameter("subjectName", subjectName);
		
		
		
		q.setParameter("levelPassed", levelPassed);
		q.setParameter("score", score);
	
		List<TableStudent> list = q.getResultList();
		
		return list;
		
		
	}
	
	
}
