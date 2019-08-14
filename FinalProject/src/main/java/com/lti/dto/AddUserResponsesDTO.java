package com.lti.dto;

public class AddUserResponsesDTO {
	private int testId;
	private int questionId;
	private String userResponse;
	
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getUserResponse() {
		return userResponse;
	}
	public void setUserResponse(String userResponse) {
		this.userResponse = userResponse;
	}
	
	

}
