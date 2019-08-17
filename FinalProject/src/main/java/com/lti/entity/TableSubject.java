package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="TABLE_SUBJECT")
public class TableSubject {
	
	@Id
	@GeneratedValue
	@Column(name="SUBJECT_ID")
	private int subjectId;
	
	@Column(name="SUBJECT_NAME")
	private String subjectName;
	
	@JsonIgnore
	@OneToMany(mappedBy="subject" ,cascade=CascadeType.ALL)
	private List<TableQuestion> subjectQuestions;
	
	@JsonIgnore
	@OneToMany(mappedBy="testSubject" ,cascade=CascadeType.ALL)
	private List<TableTest> subjectTests;
	
	public List<TableTest> getSubjectTests() {
		return subjectTests;
	}

	public void setSubjectTests(List<TableTest> subjectTests) {
		this.subjectTests = subjectTests;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public List<TableQuestion> getSubjectQuestions() {
		return subjectQuestions;
	}

	public void setSubjectQuestions(List<TableQuestion> subjectQuestions) {
		this.subjectQuestions = subjectQuestions;
	}

}
