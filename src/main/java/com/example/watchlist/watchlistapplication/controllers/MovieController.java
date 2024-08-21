package com.example.watchlist.watchlistapplication.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.watchlist.watchlistapplication.entity.Movie;
import com.example.watchlist.watchlistapplication.service.DatabaseService;

@RestController
public class MovieController {

    @Autowired
    DatabaseService databaseService;

    @GetMapping("/watchlistform")
    public ModelAndView showwatchlistform() {
        String viewName = "watchlistItemForm";

        Map<String, Object> model = new HashMap<>();

        // Movie dummyMovie = new Movie();
		// dummyMovie.setTitle("dummy");
		// dummyMovie.setRating(0);
		// dummyMovie.setPriority("Low");
		// dummyMovie.setComment("john doe");
        // model.put("watchlistItem", dummyMovie);

        model.put("watchlistItem", new Movie());
        return new ModelAndView(viewName, model);
    }

    
    @PostMapping("/watchlistItemForm")
	public ModelAndView submitWatchListForm(Movie movie){
        databaseService.create(movie);

        RedirectView rd = new RedirectView();
        rd.setUrl("/watchlist");

        return new ModelAndView(rd);
        
    }

    @GetMapping("/watchlist")
	public ModelAndView getWatchlist() {

		String viewName = "watchlist";
		Map<String, Object> model = new HashMap<>();
		List<Movie> movieList = databaseService.getAllMovies();
		model.put("watchlistrows", movieList);
		model.put("noofmovies", movieList.size());
		return new ModelAndView(viewName, model);
	}

}
