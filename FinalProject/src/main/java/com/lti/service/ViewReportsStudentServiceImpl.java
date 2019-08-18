package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ViewReportsDaoImpl;
import com.lti.entity.TableUserResult;

@Service
public class ViewReportsStudentServiceImpl {
	@Autowired
	ViewReportsDaoImpl reportDao;
	
	public List<Object[]> viewReports(int studentId) {
		 List<Object[]> list=  reportDao.viewReportsInDao(studentId);
		 return list;
				
	}

}
