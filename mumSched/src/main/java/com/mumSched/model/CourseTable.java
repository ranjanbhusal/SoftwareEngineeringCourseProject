package com.mumSched.model;

public class CourseTable {
	
	private String courseCode;
	private String courseTitle;
	private String professor;
	private Integer seatCapacity;
	
	
	public CourseTable() {}
	
	
	public String getCourseCode() {
		return courseCode;
	}


	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}


	public String getCourseTitle() {
		return courseTitle;
	}


	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}


	public String getProfessor() {
		return professor;
	}


	public void setProfessor(String professor) {
		this.professor = professor;
	}


	public Integer getSeatCapacity() {
		return seatCapacity;
	}


	public void setSeatCapacity(Integer seatCapacity) {
		this.seatCapacity = seatCapacity;
	}


	@Override
	public String toString() {
		return "CourseTable [courseCode=" + courseCode + ", courseTitle=" + courseTitle + ", professor=" + professor
				+ ", seatCapacity=" + seatCapacity + "]";
	}
	
	
	
}
