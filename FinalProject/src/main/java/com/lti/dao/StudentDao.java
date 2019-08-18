package com.lti.dao;

import com.lti.entity.TableStudent;

public interface StudentDao {
	public TableStudent validateStudentCredentials(String email, String pwd);
}
