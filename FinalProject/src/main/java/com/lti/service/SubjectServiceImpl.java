package com.lti.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDaoImpl;
import com.lti.entity.TableSubject;

@Service
public class SubjectServiceImpl {

	@Autowired
	private GenericDaoImpl dao;
	
	@Transactional
	public void addSubject(TableSubject subject) {
		subject.setSubjectName("PHP");
		//System.out.println("Service");
		dao.save(subject);
}
}
