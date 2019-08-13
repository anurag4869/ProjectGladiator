package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TABLE_USER_RESULT")
public class TableUserResult {

	@Id
	@GeneratedValue
	@Column(name="USER_RESULT_ID")
	private int userResultId;
	
	@Column(name="RESULT_STATUS")
	private String resultStatus;
	
	@Column(name="SCORE")
	private int score;
	
	@Column(name="QUESTION_LEVEL")
	private int questionLevel;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="TEST_ID") //fk
	private TableTest testUserResult;
}
