package com.lti.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.AdminDaoImpl;
import com.lti.dao.GenericDaoImpl;
import com.lti.dto.Status;
import com.lti.entity.TableAdmin;
import com.lti.entity.TableStudent;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private GenericDaoImpl dao;
	
	@Autowired
	private AdminDaoImpl adminDao;
	
	
	@Transactional
	public Status validateAdminLoginCredentials(String email,String pwd) {
	TableAdmin admin	=adminDao.validateAdminCredentials(email, pwd);
	Status status=new Status();
	if(admin==null)
	{
		 status.setGeneratedId(0);
		 status.setMessage("Invalid");
		

	}
	else {
		status.setGeneratedId(admin.getAdminId());
		status.setMessage("Valid");
	}	
	return status;
}
	
	
	@Transactional
	public List<TableStudent> searchStudents(String subjectName,String studentState,String studentCity,int levelPassed, int score) {
	List<TableStudent> listOfStudents=adminDao.searchStudents(subjectName, studentState, studentCity, levelPassed, score);
	
	return listOfStudents;
	
	}
}
