package com.lti.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TABLE_STUDENT")
public class TableStudent {
	
	@Id
	@GeneratedValue
	@Column(name="STUDENT_ID") 
	int studentId;
	
	@Column(name="STUDENT_NAME") 
	String studentName;
	
	@Column(name="STUDENT_EMAIL") 
	String studentEmail;
	
	@Column(name="STUDENT_MNO") 
	long studentMno;
	
	@Column(name="STUDENT_DOB") 
	Date studentDob;
	
	@Column(name="STUDENT_STATE") 
	String studentState;
	
	@Column(name="STUDENT_CITY") 
	String studentCity;
	
	@Column(name="STUDENT_YOC") 
	int studentYoc;
	
	@Column(name="STUDENT_PWD") 
	String studentPwd;

	public String getStudentPwd() {
		return studentPwd;
	}

	public void setStudentPwd(String studentPwd) {
		this.studentPwd = studentPwd;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public long getStudentMno() {
		return studentMno;
	}

	public void setStudentMno(long studentMno) {
		this.studentMno = studentMno;
	}



	public Date getStudentDob() {
		return studentDob;
	}

	public void setStudentDob(Date studentDob) {
		this.studentDob = studentDob;
	}

	public String getStudentState() {
		return studentState;
	}

	public void setStudentState(String studentState) {
		this.studentState = studentState;
	}

	public String getStudentCity() {
		return studentCity;
	}

	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}

	public int getStudentYoc() {
		return studentYoc;
	}

	public void setStudentYoc(int studentYoc) {
		this.studentYoc = studentYoc;
	}
	

}
