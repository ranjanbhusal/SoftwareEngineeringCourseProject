package com.mumSched.model;

public class StudentEntry {
	
	private User user;
	private Entry entry;
	
	public Entry getEntry() {
		return entry;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setEntry(Entry entry) {
		this.entry = entry;
	}
	
	@Override
	public String toString() {
		return "StudentEntry [user=" + user + ", entry=" + entry + "]";
	}
	
	
	
	
	
	
	
	

}
