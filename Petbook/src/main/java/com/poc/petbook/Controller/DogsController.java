package com.poc.petbook.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.petbook.Entities.ChannelList;
import com.poc.petbook.Entities.ChatMessages;
import com.poc.petbook.Entities.DogLike;
import com.poc.petbook.Entities.DogOwners;
import com.poc.petbook.Entities.Dogs;
import com.poc.petbook.Entities.MatchInfo;
import com.poc.petbook.Entities.SwipedBy;
import com.poc.petbook.Entities.Matched;
import com.poc.petbook.Entities.Messages;
import com.poc.petbook.Repository.ChatMessagesRepository;
import com.poc.petbook.Repository.DogOwnerRepository;
import com.poc.petbook.Repository.DogsRepository;
import com.poc.petbook.Repository.MatchedRepository;
import com.poc.petbook.Utility.RandomGenerator;

@RestController
@CrossOrigin
public class DogsController {

	@Autowired
	DogsRepository dogsRepository;
	
	@Autowired
	DogOwnerRepository dogOwnerRepository;
	
	@Autowired
	MatchedRepository matchedRepository;
	
	@Autowired
	ChatMessagesRepository chatMessagesRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	RandomGenerator randomGen;
	
	@RequestMapping(method=RequestMethod.GET,value="/dogs")
	public List<Dogs> getDogs() {
		return dogsRepository.findAll();
	}
	@RequestMapping(method=RequestMethod.GET,value="/dogOwners")
	public List<DogOwners> getDogOwners() {
		return dogOwnerRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/dogOwnerProfile/{username}")
	public DogOwners getOneDogOwner(@PathVariable String username) {
		return dogOwnerRepository.findByusername(username);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/dogOwned/{dogOwner}")
	public List<Dogs> getAllDogsOwned(@PathVariable String dogOwner){
		return dogsRepository.findAllBydogOwner(dogOwner);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/findMatches")
	public List<Dogs> getMatches(@RequestParam String username){
		return dogsRepository.findAllBydogOwnerNot(username);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/swipedRight")
	public ResponseEntity<String> swippedRight(@RequestBody Matched matched) {
		System.out.println(matched.getSwipedBy());
		System.out.println(matched.getPetName());
		System.out.println(matched.getBreedSwipedBy());
		System.out.println(matched.getUsernameSwipped());
		System.out.println(matched.getPetLike());
		System.out.println(matched.getBreedLike());
		
		Dogs dog1 = dogsRepository.findBypetNameAnddogOwner(matched.getPetName(), matched.getSwipedBy());
		Dogs dog2 = dogsRepository.findBypetNameAnddogOwner(matched.getPetLike(), matched.getUsernameSwipped());
		
		
		System.out.println(dog1);
		System.out.println(dog2);
		//Dog1
		Query query = new Query(Criteria 
				.where("_id").is(dog1.get_id())
				.and("dogOwner").is(matched.getSwipedBy())
				.and("petName").is(matched.getPetName())
				.and("swippedBy.dogName").is(matched.getPetLike()));
		
		
		List<Dogs> users = mongoTemplate.find(query, Dogs.class);
		if(users.isEmpty()) {
			System.out.println("Nope");
			DogLike doglike = new DogLike(matched.getPetLike(),matched.getBreedLike(),matched.getUsernameSwipped());
			SwipedBy swipedBy = new SwipedBy(matched.getPetName(),matched.getBreedSwipedBy(),matched.getBreedSwipedBy());
			dog1.getDoglike().add(doglike);
			dog2.getSwipedBy().add(swipedBy);
			dogsRepository.save(dog1);
			dogsRepository.save(dog2);
			return new ResponseEntity<String>("Liked",HttpStatus.OK);
		}else {
			DogLike doglike = new DogLike(matched.getPetLike(),matched.getBreedLike(),matched.getUsernameSwipped());
			SwipedBy swipedBy = new SwipedBy(matched.getPetName(),matched.getBreedSwipedBy(),matched.getBreedSwipedBy());
			dog1.getDoglike().add(doglike);
			dog2.getSwipedBy().add(swipedBy);
			dogsRepository.save(dog1);
			dogsRepository.save(dog2);
			
			
			Date matchedDate = new Date();
			
			MatchInfo matchInfoDog1 = new MatchInfo(dog1.getDogOwner(),dog1.getPetName());
			MatchInfo matchInfoDog2 = new MatchInfo(dog2.getDogOwner(),dog2.getPetName());
			
			Matched matchedNa = new Matched();
			matchedNa.setMatchedDate(matchedDate);
			matchedNa.getDog1().add(matchInfoDog1);
			matchedNa.getDog2().add(matchInfoDog2);
			
			Messages messages = new Messages("Matched!"+matchInfoDog1.toString()+" and "+ matchInfoDog2.toString(),"BOT",dog1.getDogOwner() + " " + dog2.getDogOwner(),matchedDate);
			
			String generateMessageID = randomGen.generateMessageId();
			ChatMessages chatMessages = new ChatMessages(); 
			chatMessages.setMessageId(generateMessageID);
			chatMessages.getMessages().add(messages);
			chatMessages.setMatchedDate(matchedDate);
			
			DogOwners owner1 = dogOwnerRepository.findByusername(dog1.getDogOwner());
			DogOwners owner2 = dogOwnerRepository.findByusername(dog2.getDogOwner());
			ChannelList channelss = new ChannelList(generateMessageID);
			owner1.getChannels().add(channelss);
			owner2.getChannels().add(channelss);
			
			dogOwnerRepository.save(owner1);
			dogOwnerRepository.save(owner2);
			matchedRepository.save(matchedNa);
			chatMessagesRepository.save(chatMessages);
			
			return new ResponseEntity<String>(chatMessages.getMessageId(),HttpStatus.OK);
		}
		
	}
	
	public void Matched() {
		
	}
}