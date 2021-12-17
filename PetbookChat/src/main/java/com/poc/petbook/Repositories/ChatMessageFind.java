package com.poc.petbook.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.poc.petbook.Entities.ChatMessages;

public interface ChatMessageFind extends MongoRepository<ChatMessages, String> {

	@Query(value = "{messageId : ?0}")
	ChatMessages findBymessageId(String messageId);
}
