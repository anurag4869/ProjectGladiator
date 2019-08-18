package com.lti.dao;

import java.util.List;

import com.lti.entity.TableAdmin;
import com.lti.entity.TableStudent;

public interface AdminDao {
	public TableAdmin validateAdminCredentials(String email, String pwd);
	public List<TableStudent> searchStudents(String subjectName,String studentState,String studentCity,int levelPassed, int score);
}
