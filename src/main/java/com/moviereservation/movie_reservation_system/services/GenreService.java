package com.moviereservation.movie_reservation_system.services;

import com.moviereservation.movie_reservation_system.exceptions.ResourceNotFoundException;
import com.moviereservation.movie_reservation_system.models.movies.Genre;

public interface GenreService {

    Genre findByName(String name) throws ResourceNotFoundException;
    boolean existsByName(String name);
}
