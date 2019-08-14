package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDaoImpl;
import com.lti.entity.TableStudent;
import com.lti.entity.TableSubject;
import com.lti.entity.TableTest;

@Service
public class TestServiceImpl {
	
	@Autowired
	private GenericDaoImpl dao;
	
	@Transactional
	public void addToTestTable(int studentId,int subjectId) {
	TableStudent student=dao.fetchById(TableStudent.class, studentId);
	TableSubject subject=dao.fetchById(TableSubject.class, subjectId);
	TableTest test=new TableTest();
	test.setTestStudent(student);
	test.setTestSubject(subject);
	
	dao.save(test);
	
	}

}
