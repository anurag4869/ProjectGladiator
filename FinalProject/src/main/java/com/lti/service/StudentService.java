package com.lti.service;

import com.lti.dto.Status;
import com.lti.entity.TableStudent;


public interface StudentService {
	public void addStudent(TableStudent student);
	public Status validateStudentLoginCredentials(String email,String pwd);
	
}
