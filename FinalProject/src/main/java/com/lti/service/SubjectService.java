package com.lti.service;

import java.util.List;

import com.lti.entity.TableSubject;

public interface SubjectService {
	public void addSubject(TableSubject subject);
	public List<TableSubject> getAllSubjects();
}
