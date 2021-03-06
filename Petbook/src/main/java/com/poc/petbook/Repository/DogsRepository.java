package com.poc.petbook.Repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.poc.petbook.Entities.Dogs;
import com.poc.petbook.Entities.SwipedBy;

public interface DogsRepository extends MongoRepository<Dogs, String> {

	//@Query(value = "{petName : ?0}")
	@Query(value = "{ $and: [ { 'petName' : ?0 }, { 'dogOwner' : ?1 } ] }")
	Dogs findBypetNameAnddogOwner(String petName, String dogOwner);
	
	
	List<Dogs> findAllBydogOwnerNot(String dogOwner);
	
	@Query(value = "{dogOwner : ?0}")
	List<Dogs> findAllBydogOwner(String dogOwner);
}
