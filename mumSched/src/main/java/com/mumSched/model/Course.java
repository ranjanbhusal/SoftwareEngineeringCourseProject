package com.mumSched.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


  @Entity
    public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	//@Column(unique = true)
	private String courseCode;
	//@NotNull
	private String courseName;
	private String courseDesc;
	/*@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Specialization> courseArea;*/

	@OneToMany(mappedBy="course")
	private List<BlockCourse> blockCourses;
	
	public Course() {}
	
	public Course(String courseCode, String courseName, String courseDesc) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.courseDesc = courseDesc;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	public List<BlockCourse> getBlockCourses() {
		return blockCourses;
	}

	public void setBlockCourses(List<BlockCourse> blockCourses) {
		this.blockCourses = blockCourses;
	}
}
