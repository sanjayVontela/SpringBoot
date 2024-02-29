package com.sanjay.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.sanjay.movies.dao.ReviewRepository;
import com.sanjay.movies.model.Movie;
import com.sanjay.movies.model.Reviews;

@Service
public class ReviewService {
	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	public Reviews createReview(String reviewBody, String ImdbId) {

		Reviews review = reviewRepository.insert(new Reviews(reviewBody));
		
		
		mongoTemplate.update(Movie.class).matching(Criteria.where("imdbId").is(ImdbId)).apply(new Update().push("reviewIds").value(review.getId())).first();
		
		return review;
	}

}
