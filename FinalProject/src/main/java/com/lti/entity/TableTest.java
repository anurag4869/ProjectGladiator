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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TABLE_TEST")
public class TableTest {

	@Id
	@GeneratedValue
	@Column(name="TEST_ID")
	private int testId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="SUBJECT_ID")
	@JsonBackReference
	private TableSubject testSubject;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="STUDENT_ID")
	private TableStudent testStudent;
	
	@OneToMany(mappedBy="testDetailsTest" ,cascade=CascadeType.ALL)
	@JsonIgnore
	private List<TableTestDetails> testDetailsTestList;
	
	@JsonIgnore
	@OneToOne(mappedBy="testUserResult",cascade = CascadeType.ALL)
	private TableUserResult testResult;
	
	public List<TableTestDetails> getTestDetailsTestList() {
		return testDetailsTestList;
	}

	public void setTestDetailsTestList(List<TableTestDetails> testDetailsTestList) {
		this.testDetailsTestList = testDetailsTestList;
	}

	public TableUserResult getTestResult() {
		return testResult;
	}

	public void setTestResult(TableUserResult testResult) {
		this.testResult = testResult;
	}

	

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public TableSubject getTestSubject() {
		return testSubject;
	}

	public void setTestSubject(TableSubject testSubject) {
		this.testSubject = testSubject;
	}

	public TableStudent getTestStudent() {
		return testStudent;
	}

	public void setTestStudent(TableStudent testStudent) {
		this.testStudent = testStudent;
	}
	
}
