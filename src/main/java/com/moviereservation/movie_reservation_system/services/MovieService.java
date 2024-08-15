package com.moviereservation.movie_reservation_system.services;

import com.moviereservation.movie_reservation_system.exceptions.ResourceAlreadyExistException;
import com.moviereservation.movie_reservation_system.exceptions.ResourceNotFoundException;
import com.moviereservation.movie_reservation_system.models.movies.Movie;
import com.moviereservation.movie_reservation_system.models.movies.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies() throws ResourceNotFoundException;
    Movie addMovie(MovieDTO movie) throws ResourceAlreadyExistException;
    Movie updateMovie(String id, MovieDTO movie) throws ResourceNotFoundException;
    void deleteMovie(String id) throws ResourceNotFoundException;
}
