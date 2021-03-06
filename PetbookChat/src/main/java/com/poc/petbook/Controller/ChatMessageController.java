package com.poc.petbook.Controller;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.poc.petbook.Entities.ChatMessages;
import com.poc.petbook.Repositories.ChatMessageFind;
import com.poc.petbook.Repositories.ChatMessageRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
public class ChatMessageController {

	@Autowired
	ChatMessageRepository chatMessageRepository;
	
	@Autowired
	ChatMessageFind chatMessageFind;
	
	@PostMapping("/chats")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<ChatMessages> postChat(@RequestBody ChatMessages chatMessage){	
		return chatMessageRepository.save(chatMessage);
	}
	
//	public ChatMessages postChat(@RequestBody ChatMessages chatMessage){	
//	System.out.println(chatMessageFind.findBymessageId(chatMessage.getMessageId()));
//	return chatMessage;
//}	
//
	
	@GetMapping(value = "/chats/streams", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<ChatMessages> streamMessages(@RequestParam String messageId){
		return chatMessageRepository.findWithTailableCursorBymessageId(messageId);
	}
}
