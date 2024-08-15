package com.moviereservation.movie_reservation_system.controllers.admin;

import com.moviereservation.movie_reservation_system.exceptions.ResourceAlreadyExistException;
import com.moviereservation.movie_reservation_system.models.movies.dto.MovieDTO;
import com.moviereservation.movie_reservation_system.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/movies")
public class MovieAdminController {

    @Autowired
    private MovieService movieService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> addMovie(@RequestBody MovieDTO movie) {
        try {
            movieService.addMovie(movie);
            return ResponseEntity.ok("Movie added successfully");
        } catch (ResourceAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
