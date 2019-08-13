package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TABLE_TEST_DETAILS")
public class TableTestDetails {
	
	@Id
	@GeneratedValue
	@Column(name="CURRENT_ID")
	private int currentId;
	
	@Column(name="RESPONSE_STATUS")
	private String responseStatus;
	
	@Column(name="USER_RESPONSE")
	private String userResponse;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="QUESTION_ID")
	private TableQuestion testDetailsQuestion;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="TEST_ID")
	private TableTest testDetailsTest;
	
	public int getCurrentId() {
		return currentId;
	}

	public void setCurrentId(int currentId) {
		this.currentId = currentId;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getUserResponse() {
		return userResponse;
	}

	public void setUserResponse(String userResponse) {
		this.userResponse = userResponse;
	}

	public TableQuestion getTestDetailsQuestion() {
		return testDetailsQuestion;
	}

	public void setTestDetailsQuestion(TableQuestion testDetailsQuestion) {
		this.testDetailsQuestion = testDetailsQuestion;
	}

	public TableTest getTestDetailsTest() {
		return testDetailsTest;
	}

	public void setTestDetailsTest(TableTest testDetailsTest) {
		this.testDetailsTest = testDetailsTest;
	}

	
}
