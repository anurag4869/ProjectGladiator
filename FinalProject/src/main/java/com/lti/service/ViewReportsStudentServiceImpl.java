package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ViewReportsDao;

@Service
public class ViewReportsStudentServiceImpl implements ViewReportsStudentService {
	@Autowired
	ViewReportsDao reportDao;
	
	public List<Object[]> viewReports(int studentId) {
		 List<Object[]> list=  reportDao.viewReportsInDao(studentId);
		 return list;
				
	}

}
