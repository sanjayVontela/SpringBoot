package com.telvad.JobListing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telvad.JobListing.dao.PostRepository;
import com.telvad.JobListing.dao.SearchRepository;
import com.telvad.JobListing.model.Post;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

	@Autowired 
	PostRepository repo;
	
	@Autowired
	SearchRepository srepo;
	

	
	@GetMapping("/allPosts")
	@CrossOrigin
	public List<Post> getPosts(){
		return repo.findAll();
	}
	
	@GetMapping("/posts/{text}")
	@CrossOrigin
	public List<Post> search(@PathVariable String text){
		return srepo.findByText(text);
	}
	
	
	@PostMapping("/addPost")
	@CrossOrigin
	public ResponseEntity<Map<String,String>> addPost(@RequestBody Post p) {
		Map<String, String> response = new HashMap<>();
		 if(repo.insert(p) != null) {
			 response.put("status","success");
			 return ResponseEntity.ok(response);
		 }else {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		 }

	}
}
