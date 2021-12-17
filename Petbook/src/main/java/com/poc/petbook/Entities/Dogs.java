package com.poc.petbook.Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Dogs {

	@Field
	private ObjectId _id;
	@Field
	private String petName;
	@Field
	private String breed;
	@Field
	private Date birthday;
	@Field
	private String age;
	@Field
	private String dogOwner;
	@Field
	private String gender;
	@Field
	private ArrayList<VaccinationHistory> vaccineHistory = new ArrayList<VaccinationHistory>();
	@Field
	private ArrayList<SwipedBy> swippedBy = new ArrayList<SwipedBy>();
	@Field
	private ArrayList<DogLike> doglike = new ArrayList<DogLike>();
	@Field
	private String[] imageurl;
	
	
	public Dogs() {
		
	}
	
	public Dogs(ObjectId _id, String petName, String breed, Date birthday, String age, String dogOwner, String gender,
			ArrayList<VaccinationHistory> vaccineHistory, ArrayList<SwipedBy> swippedBy, ArrayList<DogLike> doglike,
			String[] imageurl) {
		this._id = _id;
		this.petName = petName;
		this.breed = breed;
		this.birthday = birthday;
		this.age = age;
		this.dogOwner = dogOwner;
		this.gender = gender;
		this.vaccineHistory = vaccineHistory;
		this.swippedBy = swippedBy;
		this.doglike = doglike;
		this.imageurl = imageurl;
	}

	public Dogs(ArrayList<SwipedBy> swippedBy) {
		this.swippedBy = swippedBy;
	}

	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDogOwner() {
		return dogOwner;
	}
	public void setDogOwner(String dogOwner) {
		this.dogOwner = dogOwner;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public ArrayList<VaccinationHistory> getVaccinationHistory() {
		return vaccineHistory;
	}

	public void setVaccinationHistory(ArrayList<VaccinationHistory> vaccineHistory) {
		this.vaccineHistory = vaccineHistory;
	}

	public ArrayList<SwipedBy> getSwipedBy() {
		return swippedBy;
	}

	public void setSwipedBy(ArrayList<SwipedBy> swippedBy) {
		this.swippedBy = swippedBy;
	}

	public ArrayList<DogLike> getDoglike() {
		return doglike;
	}

	public void setDoglike(ArrayList<DogLike> doglike) {
		this.doglike = doglike;
	}

	public String[] getImageurl() {
		return imageurl;
	}

	public void setImageurl(String[] imageurl) {
		this.imageurl = imageurl;
	}

	@Override
	public String toString() {
		return "Dogs [_id=" + _id + ", petName=" + petName + ", breed=" + breed + ", birthday=" + birthday + ", age="
				+ age + ", dogOwner=" + dogOwner + ", gender=" + gender + ", vaccineHistory=" + vaccineHistory
				+ ", swippedBy=" + swippedBy + ", doglike=" + doglike + ", imageurl=" + Arrays.toString(imageurl) + "]";
	}
	
}
