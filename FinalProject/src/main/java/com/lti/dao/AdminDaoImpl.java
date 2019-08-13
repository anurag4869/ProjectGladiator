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
	
	public List<TableStudent> searchStudents(String subjectName,String studentState,String studentCity,int questionLevel, int score){
	
		//String query="select s.StudentName from TableStudent s where s.STUDENT_ID in( select stud.STUDENT_ID from Tabl_STUDENT stud, TABLE_TEST t, TABLE_SUBJECT sub, TABLE_USER_RESULT ur, TABLE_CURR_TEST ct where\r\n" + 
			//	"sub.SUBJECT_NAME='JAVA' and stud.STUDENT_CITY='THANE' and stud.STUDENT_STATE='MAHARASHTRA' and ur.QUESTION_LEVEL=1 and \r\n" + 
				//"ur.SCORE=1) ;\r\n" + 
				//" ";
		
		
		System.out.println("daooooooooo");
		
		System.out.println(subjectName);
		System.out.println(studentState);
		System.out.println(studentCity);
		System.out.println(questionLevel);
		System.out.println(score);
		
		String query=" select stud from TableStudent stud, TableTest t, TableSubject subj, TableUserResult ur where "+
		"subj.subjectName = :subjectName and stud.studentCity = :studentCity and stud.studentState = :studentState and ur.questionLevel = :questionLevel " +
				"and ur.score = :score and stud.studentId = t.testStudent.studentId and subj.subjectId = t.testSubject.subjectId and t.testId = ur.testUserResult.testId";
		
	//	String query= "Select s from TableStudent s, TableTest t where s.studentId=t.testStudent.studentId";
	    Query q = entityManager.createQuery(query);
		q.setParameter("subjectName", subjectName);
		q.setParameter("studentState", studentState);
		q.setParameter("studentCity", studentCity);
		q.setParameter("questionLevel", questionLevel);
		q.setParameter("score", score);
		System.out.println("hey");	
		List<TableStudent> listOfStudents=q.getResultList();
		System.out.println(listOfStudents.size());
		
		/*for(TableStudent t: listOfStudents)
		{
		System.out.println(t.getStudentName());	
		System.out.println("heydao");	
		}*/
		return listOfStudents;
		
		
		
	}
	
	
}
