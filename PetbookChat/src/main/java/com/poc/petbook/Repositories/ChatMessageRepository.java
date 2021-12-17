package com.poc.petbook.Repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;

import com.poc.petbook.Entities.ChatMessages;

import reactor.core.publisher.Flux;

@Repository
public interface ChatMessageRepository extends ReactiveMongoRepository<ChatMessages, String> {
	
	@Tailable
	public Flux<ChatMessages> findWithTailableCursorBymessageId(String messageId);
}
