package com.poc.petbook.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.poc.petbook.Entities.DogOwners;

public interface DogOwnerRepository extends MongoRepository<DogOwners, String> {
	
	@Query(value = "{username : ?0}")
	DogOwners findByusername(String username);
}
