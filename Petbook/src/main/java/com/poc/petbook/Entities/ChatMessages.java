package com.poc.petbook.Entities;

import java.util.ArrayList;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class ChatMessages {

	@Field
	private ObjectId _id;
	@Field
	private String messageId;
	@Field
	private ArrayList<Messages> messages = new ArrayList<Messages>();
	@Field
	private Date matchedDate;
	
	public ChatMessages() {
	}
	
	public ChatMessages(String messageId,ArrayList<Messages> messages, Date matchedDate) {
		this.messageId = messageId;
		this.messages = messages;
		this.matchedDate = matchedDate;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public ArrayList<Messages> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Messages> messages) {
		this.messages = messages;
	}

	public Date getMatchedDate() {
		return matchedDate;
	}

	public void setMatchedDate(Date matchedDate) {
		this.matchedDate = matchedDate;
	}
	
}
