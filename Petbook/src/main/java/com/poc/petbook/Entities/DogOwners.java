package com.poc.petbook.Entities;

import java.util.ArrayList;
import java.util.Arrays;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(value = "dog_owners")
public class DogOwners {

	@Field
	private ObjectId _id;
	@Field
	private String username;
	@Field
	private String address;
	@Field
	private ArrayList<DogsOwned> dogs = new ArrayList<DogsOwned>();
	@Field
	private ArrayList<ChannelList> channels = new ArrayList<ChannelList>();
	
	public DogOwners() {
		
	}

	public DogOwners(ObjectId _id, String username, String address, ArrayList<DogsOwned> dogs,
			ArrayList<ChannelList> channels) {
		this._id = _id;
		this.username = username;
		this.address = address;
		this.dogs = dogs;
		this.channels = channels;
	}


	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ArrayList<DogsOwned> getDogs() {
		return dogs;
	}
	public void setDogs(ArrayList<DogsOwned> dogs) {
		this.dogs = dogs;
	}
	
	public ArrayList<ChannelList> getChannels() {
		return channels;
	}

	public void setChannels(ArrayList<ChannelList> channels) {
		this.channels = channels;
	}

	@Override
	public String toString() {
		return "DogOwners [_id=" + _id + ", username=" + username + ", address=" + address + ", dogs=" + dogs
				+ ", channels=" + channels + "]";
	}
	
}
