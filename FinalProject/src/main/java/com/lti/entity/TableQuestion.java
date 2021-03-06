package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="TABLE_QUESTION")
public class TableQuestion {
	@Id
	@GeneratedValue
	@Column(name="QUESTION_ID")
	private int questionId;
	
	@Column(name="QUESTION")
	private String question;
	
	@Column(name="CHOICE1")
	private String choiceOne;
	
	@Column(name="CHOICE2")
	private String choiceTwo;
	
	@Column(name="CHOICE3")
	private String choiceThree;
	
	@Column(name="CHOICE4")
	private String choiceFour;
	
	@Column(name="CORRECT_ANS")
	private String correctAns;
	
	@Column(name="QUESTION_LEVEL")
	private int questionLevel;
	
	@Column(name="QUESTION_STATUS")
	private int questionStatus;
	
	public int getQuestionStatus() {
		return questionStatus;
	}

	public void setQuestionStatus(int questionStatus) {
		this.questionStatus = questionStatus;
	}

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="SUBJECT_ID")
	private TableSubject subject;
	
	@JsonIgnore
	@OneToMany(mappedBy="testDetailsQuestion" ,cascade=CascadeType.ALL)
	private List<TableTestDetails> testDetailsQuestionList;

	public List<TableTestDetails> getTestDetailsQuestionList() {
		return testDetailsQuestionList;
	}

	public void setTestDetailsQuestionList(List<TableTestDetails> testDetailsQuestionList) {
		this.testDetailsQuestionList = testDetailsQuestionList;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getChoiceOne() {
		return choiceOne;
	}

	public void setChoiceOne(String choiceOne) {
		this.choiceOne = choiceOne;
	}

	public String getChoiceTwo() {
		return choiceTwo;
	}

	public void setChoiceTwo(String choiceTwo) {
		this.choiceTwo = choiceTwo;
	}

	public String getChoiceThree() {
		return choiceThree;
	}

	public void setChoiceThree(String choiceThree) {
		this.choiceThree = choiceThree;
	}

	public String getChoiceFour() {
		return choiceFour;
	}

	public void setChoiceFour(String choiceFour) {
		this.choiceFour = choiceFour;
	}

	public String getCorrectAns() {
		return correctAns;
	}

	public void setCorrectAns(String correctAns) {
		this.correctAns = correctAns;
	}

	public int getQuestionLevel() {
		return questionLevel;
	}

	public void setQuestionLevel(int questionLevel) {
		this.questionLevel = questionLevel;
	}

	public TableSubject getSubject() {
		return subject;
	}

	public void setSubject(TableSubject subject) {
		this.subject = subject;
	}


}
