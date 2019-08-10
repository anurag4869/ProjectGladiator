package com.lti.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="TABLE_SUBJECT")
public class TableSubject {
	
	@Id
	@GeneratedValue
	@Column(name="SUBJECT_ID")
	private int subjectId;
	
	@Column(name="SUBJECT_NAME")
	private String subjectName;
	
	@OneToMany(mappedBy="subject" ,cascade=CascadeType.ALL)
	private Set<TableQuestion> questions;
	
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

	public Set<TableQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<TableQuestion> questions) {
		this.questions = questions;
	}


}
