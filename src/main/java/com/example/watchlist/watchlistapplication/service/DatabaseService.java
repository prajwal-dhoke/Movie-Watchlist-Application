package com.example.watchlist.watchlistapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.watchlist.watchlistapplication.Repository.MovieRepo;
import com.example.watchlist.watchlistapplication.entity.Movie;

@Service
public class DatabaseService {
    @Autowired
    MovieRepo movieRepo;
    public void create(Movie movie){
        movieRepo.save(movie);
    }

    public List<Movie> getAllMovies(){

        return movieRepo.findAll();
    }

    public Movie getMovieById(Integer id){

        return movieRepo.findById(id).get();
    }

    public void update(Movie movie, Integer id) {
        Movie toBeUpdated = movieRepo.findById(id).get();
        toBeUpdated.setTitle(movie.getTitle());
        toBeUpdated.setRating(movie.getRating());
        toBeUpdated.setPriority(movie.getPriority());
        toBeUpdated.setComment(movie.getComment());
        movieRepo.save(toBeUpdated);
    }
}
