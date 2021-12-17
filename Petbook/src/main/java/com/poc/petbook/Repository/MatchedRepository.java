package com.poc.petbook.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poc.petbook.Entities.Matched;

public interface MatchedRepository extends MongoRepository<Matched, String> {

}
