package com.mumSched.model;

import java.util.Arrays;

public class SelectedCourse {
	
	private String [] firstCourse;
	private String[] secondCourse;
	private String [] thirdCourse;
	private String [] fourthCourse;
	
	public SelectedCourse(String[] firstCourse, String[] secondCourse, String[] thirdCourse, String[] fourthCourse) {
		super();
		this.firstCourse = firstCourse;
		this.secondCourse = secondCourse;
		this.thirdCourse = thirdCourse;
		this.fourthCourse = fourthCourse;
	}
	
	public String[] getFirstCourse() {
		return firstCourse;
	}
	public void setFirstCourse(String[] firstCourse) {
		this.firstCourse = firstCourse;
	}
	public String[] getSecondCourse() {
		return secondCourse;
	}
	public void setSecondCourse(String[] secondCourse) {
		this.secondCourse = secondCourse;
	}
	public String[] getThirdCourse() {
		return thirdCourse;
	}
	public void setThirdCourse(String[] thirdCourse) {
		this.thirdCourse = thirdCourse;
	}
	public String[] getFourthCourse() {
		return fourthCourse;
	}
	public void setFourthCourse(String[] fourthCourse) {
		this.fourthCourse = fourthCourse;
	}

	@Override
	public String toString() {
		return "SelectedCourse [firstCourse=" + Arrays.toString(firstCourse) + ", secondCourse="
				+ Arrays.toString(secondCourse) + ", thirdCourse=" + Arrays.toString(thirdCourse) + ", fourthCourse="
				+ Arrays.toString(fourthCourse) + "]";
	}
	
	

}
