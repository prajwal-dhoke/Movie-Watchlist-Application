package com.example.watchlist.watchlistapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.watchlist.watchlistapplication.entity.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer>{

}
