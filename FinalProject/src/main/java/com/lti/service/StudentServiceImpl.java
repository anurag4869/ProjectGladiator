package com.lti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.GenericDaoImpl;
import com.lti.dao.StudentDaoImpl;
import com.lti.entity.TableStudent;

@Service
public class StudentServiceImpl{
	@Autowired
	private GenericDaoImpl dao;
	
	@Autowired
	private StudentDaoImpl studentDao;
	
	@Transactional
	public void addStudent(TableStudent student) {
	dao.save(student);
	}
	
	@Transactional
	public String validateStudentLoginCredentials(String email,String pwd) {
	Object obj=studentDao.validateStudentCredentials(email, pwd);
	String value="";
	if(obj==null)
	{
		value="False";
		return value;

	}
	else
		value="True";
		return value;
}
}
