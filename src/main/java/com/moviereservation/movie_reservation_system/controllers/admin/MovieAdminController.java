package com.moviereservation.movie_reservation_system.controllers.admin;

import com.moviereservation.movie_reservation_system.exceptions.ResourceAlreadyExistException;
import com.moviereservation.movie_reservation_system.exceptions.ResourceNotFoundException;
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

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable String id, @RequestBody MovieDTO movie) {
        try {
            movieService.updateMovie(id, movie);
            return ResponseEntity.ok("Movie updated successfully");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/deactivate/{id}")
    public ResponseEntity<?> deactivateMovie(@PathVariable String id) {
        try {
            movieService.deactivateMovie(id);
            return ResponseEntity.ok("Movie deactivated successfully");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable String id) {
       try {
              movieService.deleteMovie(id);
              return ResponseEntity.ok("Movie deleted successfully");
       } catch (ResourceNotFoundException e) {
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }
}
