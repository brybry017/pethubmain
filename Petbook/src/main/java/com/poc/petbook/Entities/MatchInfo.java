package com.poc.petbook.Entities;

public class MatchInfo {

	private String username;
	private String petName;
	
	public MatchInfo() {
		
	}
	
	public MatchInfo(String username, String petName) {
		this.username = username;
		this.petName = petName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	@Override
	public String toString() {
		return "username=" + username + ", petName=" + petName;
	}
}
