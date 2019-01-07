package com.mumSched.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Block {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String blockMonth;
	private int numOfStudents;
	private int blockOrder;

	@ManyToMany(mappedBy = "blocks", fetch = FetchType.EAGER)
	private List<Entry> entry;

	@OneToMany(mappedBy = "block")
	private List<BlockCourse> blockCourses;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Entry> getEntry() {
		return entry;
	}

	public void setEntry(List<Entry> entry) {
		this.entry = entry;
	}

	public List<BlockCourse> getBlockCourses() {
		return blockCourses;
	}

	public void setBlockCourses(List<BlockCourse> blockCourses) {
		this.blockCourses = blockCourses;
	}

	public String getBlockMonth() {
		return blockMonth;
	}

	public void setBlockMonth(String blockMonth) {
		this.blockMonth = blockMonth;
	}

	public int getNumOfStudents() {
		return numOfStudents;
	}

	public void setNumOfStudents(int numOfStudents) {
		this.numOfStudents = numOfStudents;
	}

	public int getBlockOrder() {
		return blockOrder;
	}

	public void setBlockOrder(int blockOrder) {
		this.blockOrder = blockOrder;
	}

	@Override
	public String toString() {
		return "Block [blockMonth=" + blockMonth + ", numOfStudents=" + numOfStudents + "]";
	}

	
}
