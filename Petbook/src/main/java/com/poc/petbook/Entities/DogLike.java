package com.poc.petbook.Entities;

public class DogLike {

	private String dogName;
	private String breed;
	private String dogOwner;

	public DogLike() {
		
	}

	public DogLike(String dogName, String breed, String dogOwner) {
		this.dogName = dogName;
		this.breed = breed;
		this.dogOwner = dogOwner;
	}
	
	public String getDogname() {
		return dogName;
	}

	public void setDogname(String dogName) {
		this.dogName = dogName;
	}
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getDogOwner() {
		return dogOwner;
	}

	public void setDogOwner(String dogOwner) {
		this.dogOwner = dogOwner;
	}

	@Override
	public String toString() {
		return "DogLike [dogName=" + dogName + ", breed=" + breed + ", dogOwner=" + dogOwner + "]";
	}
}
