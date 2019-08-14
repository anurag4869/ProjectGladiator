package com.lti.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.AdminDaoImpl;
import com.lti.dao.GenericDaoImpl;
import com.lti.entity.TableStudent;

@Service
public class AdminServiceImpl {
	@Autowired
	private GenericDaoImpl dao;
	
	@Autowired
	private AdminDaoImpl adminDao;
	
	
	@Transactional
	public String validateAdminLoginCredentials(String email,String pwd) {
	Object obj=adminDao.validateAdminCredentials(email, pwd);
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
	
	@Transactional
	public List<TableStudent> searchStudents(String subjectName,String studentState,String studentCity,int questionLevel, int score) {
	List<TableStudent> listOfStudents=adminDao.searchStudents(subjectName, studentState, studentCity, questionLevel, score);
	for(TableStudent t: listOfStudents)
	{
	System.out.println(t.getStudentName());	
	System.out.println("ADMINSERVICE");	
	}
	
	return listOfStudents;
	
	}
}
