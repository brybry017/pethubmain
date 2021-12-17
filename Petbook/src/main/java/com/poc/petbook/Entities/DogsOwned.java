package com.poc.petbook.Entities;

public class DogsOwned {
	
	private String dogname;
	
	public DogsOwned() {
		
	}

	public DogsOwned(String dogname) {
		this.dogname = dogname;
	}
	
	public String getDogname() {
		return dogname;
	}

	public void setDogname(String dogname) {
		this.dogname = dogname;
	}
}
