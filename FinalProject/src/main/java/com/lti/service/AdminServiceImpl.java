package com.lti.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.AdminDaoImpl;
import com.lti.dao.GenericDaoImpl;

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
}
