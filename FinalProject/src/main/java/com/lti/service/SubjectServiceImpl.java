package com.lti.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDaoImpl;
import com.lti.entity.TableQuestion;
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
	
	public List<TableSubject> getAllSubjects(){
		List<TableSubject>list=dao.fetchAll(TableSubject.class);
		return list;
	}
}
