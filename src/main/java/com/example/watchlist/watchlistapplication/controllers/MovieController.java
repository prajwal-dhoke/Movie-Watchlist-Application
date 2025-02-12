package com.example.watchlist.watchlistapplication.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.watchlist.watchlistapplication.entity.Movie;
import com.example.watchlist.watchlistapplication.service.DatabaseService;

import jakarta.validation.Valid;

@Controller
public class MovieController {

    @Autowired
    private DatabaseService databaseService;

    @GetMapping("/watchlistItemForm")
    public ModelAndView showWatchlistItemForm(@RequestParam(required = false) Integer id) {
        String viewName = "watchlistItemForm";
        Map<String, Object> model = new HashMap<>();

        // Handle the case where the ID is provided but the movie is not found
        if (id != null) {
            Movie movie = databaseService.getMovieById(id);
            if (movie != null) {
                model.put("watchlistItem", movie);
            } else {
                model.put("watchlistItem", new Movie()); // Default to an empty Movie object
            }
        } else {
            model.put("watchlistItem", new Movie());
        }

        return new ModelAndView(viewName, model);
    }

    @PostMapping("/watchlistItemForm")
    public ModelAndView submitWatchListForm(@Valid @ModelAttribute("watchlistItem") Movie movie, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("watchlistItemForm");
        }

        if (movie.getId() == null) {
            databaseService.create(movie);
        } else {
            databaseService.update(movie, movie.getId());
        }

        return new ModelAndView(new RedirectView("/watchlist", true));
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
