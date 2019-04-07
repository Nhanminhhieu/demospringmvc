package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_info")
public class StudentInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "info_id")
	private int infoId;	
	 
	@Column(name = "address")
	private String addressStudent;
	
	@Column(name = "average_score")
	private String averageScore;

	@Column(name = "date_of_birth")
	private String birthDay;

	public int getInfoId() {
		return infoId;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
	
	public String getAddressStudent() {
		return addressStudent;
	}

	public void setAddressStudent(String addressStudent) {
		this.addressStudent = addressStudent;
	}

	public String getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(String averageScore) {
		this.averageScore = averageScore;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	
	@OneToOne
	@JoinColumn(name="student_id")
	 private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}	
	 
}
