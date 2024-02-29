package com.telvad.JobListing.dao;

import java.util.List;

import com.telvad.JobListing.model.Post;

public interface SearchRepository {

	
	public List<Post> findByText(String Text);
	
}
