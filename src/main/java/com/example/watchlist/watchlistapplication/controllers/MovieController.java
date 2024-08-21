package com.example.watchlist.watchlistapplication.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.watchlist.watchlistapplication.entity.Movie;

@RestController
public class MovieController {

    @GetMapping("/watchlistform")
    public ModelAndView showwatchlistform(){
        String viewName = "watchlistitemForm";

        Map<String,Object> model = new HashMap<>();
        model.put("watchlistItem", new Movie());
        return new ModelAndView(viewName,model);
    }
}
