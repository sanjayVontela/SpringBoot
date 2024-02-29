package com.telvad.JobListing.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.telvad.JobListing.model.Post;

public interface PostRepository extends MongoRepository<Post, String>{
	


}
