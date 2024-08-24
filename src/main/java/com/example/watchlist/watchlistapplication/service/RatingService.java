package com.example.watchlist.watchlistapplication.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class RatingService {
    String apiUrl = "https://www.omdbapi.com/?apikey=f85976e5&t=";

    
    @SuppressWarnings("null")
    public String getMovieRating(String title) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<ObjectNode> response = restTemplate.getForEntity(apiUrl + title, ObjectNode.class);
            ObjectNode jsonObject = response.getBody();
            return jsonObject.path("imdbRating").asText();
        } catch (RestClientException e) {
            System.out.println("Either Movie not found or API is not available");
            return null;
        }
    }
}
