package com.sanjay.movies.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanjay.movies.model.Movie;
import com.sanjay.movies.service.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "*")
public class MovieController {
    @Autowired
    MovieService service;
    
    @GetMapping("/allMovies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = service.allMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    
    @GetMapping("/movie/{id}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable ObjectId id) {
    	Optional<Movie> m = service.getMoviebyId(id);
    	return new ResponseEntity<Optional<Movie>>(m,HttpStatus.OK);
    	
    }
    @GetMapping("/movie/imdb/{id}")
    public ResponseEntity<Optional<Movie>> getMovieImdb(@PathVariable String id) {
    	Optional<Movie> m = service.getMoviebyImdbId(id);
    	return new ResponseEntity<Optional<Movie>>(m,HttpStatus.OK);
    	
    }
}
