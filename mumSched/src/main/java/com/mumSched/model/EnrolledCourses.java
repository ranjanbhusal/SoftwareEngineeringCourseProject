package com.mumSched.model;

import javax.persistence.Entity;

//@Entity
public class EnrolledCourses {
	private String studentName;
	private String firstCourse;
	private String secondCourse;
	private String thirdCourse;
	private String fourthCourse;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getFirstCourse() {
		return firstCourse;
	}
	public void setFirstCourse(String firstCourse) {
		this.firstCourse = firstCourse;
	}
	public String getSecondCourse() {
		return secondCourse;
	}
	public void setSecondCourse(String secondCourse) {
		this.secondCourse = secondCourse;
	}
	public String getThirdCourse() {
		return thirdCourse;
	}
	public void setThirdCourse(String thirdCourse) {
		this.thirdCourse = thirdCourse;
	}
	public String getFourthCourse() {
		return fourthCourse;
	}
	public void setFourthCourse(String fourthCourse) {
		this.fourthCourse = fourthCourse;
	}
	
	
}
