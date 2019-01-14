package com.mumSched.model;

public class SelectedCourse2 {
	
	private CourseTable first;
	private CourseTable second;
	private CourseTable third;
	private CourseTable fourth;
	
	public SelectedCourse2(CourseTable first, CourseTable second, CourseTable third, CourseTable fourth) {
		super();
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
	}

	public CourseTable getFirst() {
		return first;
	}

	public void setFirst(CourseTable first) {
		this.first = first;
	}

	public CourseTable getSecond() {
		return second;
	}

	public void setSecond(CourseTable second) {
		this.second = second;
	}

	public CourseTable getThird() {
		return third;
	}

	public void setThird(CourseTable third) {
		this.third = third;
	}

	public CourseTable getFourth() {
		return fourth;
	}

	public void setFourth(CourseTable fourth) {
		this.fourth = fourth;
	}

	@Override
	public String toString() {
		return "SelectedCourse2 [first=" + first + ", second=" + second + ", third=" + third + ", fourth=" + fourth
				+ "]";
	}
	
	
	
}
