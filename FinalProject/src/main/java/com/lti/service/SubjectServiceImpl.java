package com.lti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.GenericDaoImpl;
import com.lti.entity.TableSubject;

@Service
public class SubjectServiceImpl {

	@Autowired
	private GenericDaoImpl dao;
	
	@Transactional
	public void addSubject(TableSubject subject) {
	dao.save(subject);
}
}
