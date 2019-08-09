package com.lti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.GenericDAO;
import com.lti.entity.TableStudent;

@Service
public class StudentService {
	@Autowired
	private GenericDAO dao;
	
	@Transactional
	public void addStudent(TableStudent student) {
	dao.save(student);
	}
	
	/*@Transactional
	public boolean validateLoginCredentials(Object obj) {
		da
}*/
}
