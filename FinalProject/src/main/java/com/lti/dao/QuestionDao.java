package com.lti.dao;

import java.util.List;

import com.lti.entity.TableQuestion;

public interface QuestionDao {
	public void deleteQuestion(int questionId);
	public List<Integer> fetchQuestionsById(int pk);
	public List<TableQuestion> fetchAll(int subjectId);
}
