package com.lti.service;

import java.util.List;

import com.lti.dto.Status;
import com.lti.entity.TableStudent;

public interface AdminService {

	public List<TableStudent> searchStudents(String subjectName,String studentState,String studentCity,int levelPassed, int score);
	public Status validateAdminLoginCredentials(String email,String pwd);
}
