package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.TableUserResult;

@Repository
public class ViewReportsDaoImpl {
	@PersistenceContext
	protected EntityManager entityManager;
	
	public List<Object[]> viewReportsInDao(int studentId) {
		
		//String q=" select stud from TableStudent as stud join stud.testStudents as ts join ts.testSubject as sub join ts.testResult as result where stud.studentId=:studentId";
		//String q1="select ur from TableUserResult as ur join ur.testUserResult as tur join tur.testStudent as testStud where testStud.studentId=:studentId ";
		String q2="select ur.score,ur.resultStatus,testSubject.subjectName from TableUserResult as ur join ur.testUserResult as tur join tur.testStudent as testStud join tur.testSubject as testSubject where testStud.studentId=:studentId ";
		Query query=entityManager.createQuery(q2);
		query.setParameter("studentId", studentId);
	
		return  query.getResultList();
		
	}

}
