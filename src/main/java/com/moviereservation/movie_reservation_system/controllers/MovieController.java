package com.moviereservation.movie_reservation_system.controllers;

import com.moviereservation.movie_reservation_system.exceptions.ResourceNotFoundException;
import com.moviereservation.movie_reservation_system.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(movieService.getMovieById(id));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> searchMoviesByOptionalParams(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "director", required = false) String director,
            @RequestParam(value = "nationality", required = false) String nationality,
            @RequestParam(value = "qualification", required = false) String qualification,
            @RequestParam(value = "distributor", required = false) String distributor,
            @RequestParam(value = "genre", required = false) String genre,
            @RequestParam(value = "language", required = false) String language,
            @RequestParam(value = "actor", required = false) String actor) {
        try {
            return ResponseEntity.ok(movieService.findMoviesByOptionalParams(name, director, nationality, qualification, distributor, genre, language, actor));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
