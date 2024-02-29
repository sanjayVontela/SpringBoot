package com.sanjay.movies.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanjay.movies.dao.MovieRepository;
import com.sanjay.movies.model.Movie;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository repo;
	
	public List<Movie> allMovies(){
		return repo.findAll();
	}
	
	public Optional<Movie> getMoviebyId(ObjectId id) {
		return repo.findById(id);
	}
	
	public Optional<Movie> getMoviebyImdbId(String id) {
		return repo.findByImdbId(id);
	}
}
