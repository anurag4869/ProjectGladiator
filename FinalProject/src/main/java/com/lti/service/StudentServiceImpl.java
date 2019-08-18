package com.lti.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDaoImpl;
import com.lti.dao.StudentDaoImpl;
import com.lti.dto.Status;
import com.lti.entity.TableAdmin;
import com.lti.entity.TableStudent;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private GenericDaoImpl dao;
	
	@Autowired
	private StudentDaoImpl studentDao;
	
	@Transactional
	public void addStudent(TableStudent student) {
	dao.save(student);
	}
	
	@Transactional
	public Status validateStudentLoginCredentials(String email,String pwd) {
		TableStudent student	=studentDao.validateStudentCredentials(email, pwd);
		Status status=new Status();
		if(student==null)
		{
			 status.setGeneratedId(0);
			 status.setMessage("Invalid");
			 
			

		}
		else {
			status.setGeneratedId(student.getStudentId());
			status.setMessage("Valid");
			status.setName(student.getStudentName());
		
		}
			
		return status;
}
}
