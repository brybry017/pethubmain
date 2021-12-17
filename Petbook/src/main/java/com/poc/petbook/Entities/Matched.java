package com.poc.petbook.Entities;

import java.util.ArrayList;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Matched {

	@Field
	private ObjectId _id;
	@Field
	private Date matchedDate;
	@Field
	private ArrayList<MatchInfo> dog1 = new ArrayList<MatchInfo>();
	@Field
	private ArrayList<MatchInfo> dog2  = new ArrayList<MatchInfo>();
	
	
	private String swipedBy;
	private String usernameSwipped;
	private String PetName;
	private String PetLike;
	private String breedSwipedBy;
	private String breedLike;
	

	
	public Matched() {
		
	}
	
	public Matched(String swipedBy, String petName, String breedSwipedBy, String usernameSwipped, String petLike, String breedLike) {
		this.swipedBy = swipedBy;
		PetName = petName;
		this.breedSwipedBy = breedSwipedBy;
		this.usernameSwipped = usernameSwipped;
		PetLike = petLike;
		this.breedLike = breedLike;
	}
	

	public Matched(Date matchedDate, ArrayList<MatchInfo> dog1, ArrayList<MatchInfo> dog2) {
		this.matchedDate = matchedDate;
		this.dog1 = dog1;
		this.dog2 = dog2;
	}

	public ObjectId get_id() {
		return _id;
	}


	public void set_id(ObjectId _id) {
		this._id = _id;
	}



	public Date getMatchedDate() {
		return matchedDate;
	}

	public void setMatchedDate(Date matchedDate) {
		this.matchedDate = matchedDate;
	}

	public ArrayList<MatchInfo> getDog1() {
		return dog1;
	}

	public void setDog1(ArrayList<MatchInfo> dog1) {
		this.dog1 = dog1;
	}

	public ArrayList<MatchInfo> getDog2() {
		return dog2;
	}

	public void setDog2(ArrayList<MatchInfo> dog2) {
		this.dog2 = dog2;
	}

	public String getSwipedBy() {
		return swipedBy;
	}

	public void setSwipedBy(String swipedBy) {
		this.swipedBy = swipedBy;
	}

	public String getPetName() {
		return PetName;
	}

	public void setPetName(String petName) {
		PetName = petName;
	}

	public String getPetLike() {
		return PetLike;
	}

	public void setPetLike(String petLike) {
		PetLike = petLike;
	}

	public String getUsernameSwipped() {
		return usernameSwipped;
	}

	public void setUsernameSwipped(String usernameSwipped) {
		this.usernameSwipped = usernameSwipped;
	}

	public String getBreedSwipedBy() {
		return breedSwipedBy;
	}

	public void setBreedSwipedBy(String breedSwipedBy) {
		this.breedSwipedBy = breedSwipedBy;
	}

	public String getBreedLike() {
		return breedLike;
	}

	public void setBreedLike(String breedLike) {
		this.breedLike = breedLike;
	}
	@Override
	public String toString() {
		return "Matched [_id=" + _id + ", matchedDate=" + matchedDate + ", dog1=" + dog1 + ", dog2=" + dog2 + "]";
	}

	
}
