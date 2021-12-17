package com.poc.petbook.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poc.petbook.Entities.ChatMessages;

public interface ChatMessagesRepository extends MongoRepository<ChatMessages, String> {

}
