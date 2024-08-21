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
}
