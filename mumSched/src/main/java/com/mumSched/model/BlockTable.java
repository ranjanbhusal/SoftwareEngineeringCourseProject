package com.mumSched.model;

import java.util.List;

public final class BlockTable {
	
	private String blockMonth;
	List<CourseTable> courseTable;
	
	public BlockTable() {}
	public BlockTable(String blockMonth, List<CourseTable> courseTable) {
		this.blockMonth = blockMonth;
		this.courseTable = courseTable;
	}
	
	public String getBlockMonth() {
		return blockMonth;
	}
	public void setBlockMonth(String blockMonth) {
		this.blockMonth = blockMonth;
	}
	public List<CourseTable> getCourseTable() {
		return courseTable;
	}
	public void setCourseTable(List<CourseTable> courseTable) {
		this.courseTable = courseTable;
	}
	
	@Override
	public String toString() {
		return "BlockTable [blockMonth=" + blockMonth + ", courseTable=" + courseTable + "]";
	}
	
	

}
