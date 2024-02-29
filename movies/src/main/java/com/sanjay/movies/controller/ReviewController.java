package com.sanjay.movies.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanjay.movies.model.Reviews;
import com.sanjay.movies.service.ReviewService;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

	
	@Autowired
	private ReviewService reviewservice;
	
	@PostMapping("/insertReview")
	public ResponseEntity<Reviews> insertReview(@RequestBody Map<String, String> payload){
		return new ResponseEntity<Reviews>(reviewservice.createReview(payload.get("reviewBody"), payload.get("ImdbId")),HttpStatus.CREATED);
	}
}
