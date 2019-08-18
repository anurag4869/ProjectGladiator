package com.lti.service;

import java.util.List;

import com.lti.entity.TableQuestion;

public interface QuestionService {
	
	public int addQuestion(TableQuestion question);
	public void addQuestionForSubject( int questionId,int subjectId);
	public List<TableQuestion> getAllQuestions(int subjectId);
	public void deleteQuestion(int questionId);
	public List<Integer> getQuestionForStudent(int subjectId);
	public TableQuestion getASingleQuestionForStudent(int  questionId);
}
