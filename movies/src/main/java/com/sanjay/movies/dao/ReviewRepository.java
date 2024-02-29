package com.sanjay.movies.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sanjay.movies.model.Reviews;

@Repository
public interface ReviewRepository extends MongoRepository<Reviews, ObjectId>{

	
	
}
