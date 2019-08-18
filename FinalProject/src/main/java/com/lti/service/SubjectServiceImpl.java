package com.lti.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDao;
import com.lti.entity.TableSubject;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private GenericDao dao;
	
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
