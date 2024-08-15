package com.moviereservation.movie_reservation_system.services;

import com.moviereservation.movie_reservation_system.exceptions.ResourceAlreadyExistException;
import com.moviereservation.movie_reservation_system.exceptions.ResourceNotFoundException;
import com.moviereservation.movie_reservation_system.models.movies.Movie;
import com.moviereservation.movie_reservation_system.models.movies.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    Movie getMovieById(String id) throws ResourceNotFoundException;
    List<Movie> findMoviesByOptionalParams(
            String name,
            String director,
            String nationality,
            String qualification,
            String distributor,
            String genre,
            String language,
            String actor) throws ResourceNotFoundException;
    Movie addMovie(MovieDTO movie) throws ResourceAlreadyExistException;
    Movie updateMovie(String id, MovieDTO movie) throws ResourceNotFoundException;
    void deleteMovie(String id) throws ResourceNotFoundException;
    void deactivateMovie(String id) throws ResourceNotFoundException;
}
