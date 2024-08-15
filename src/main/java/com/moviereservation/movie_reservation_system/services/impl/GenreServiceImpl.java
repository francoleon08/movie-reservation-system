package com.moviereservation.movie_reservation_system.services.impl;

import com.moviereservation.movie_reservation_system.exceptions.ResourceNotFoundException;
import com.moviereservation.movie_reservation_system.models.movies.Genre;
import com.moviereservation.movie_reservation_system.repositories.GenreRepository;
import com.moviereservation.movie_reservation_system.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre findByName(String name) throws ResourceNotFoundException {
        return genreRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found"));
    }

    @Override
    public boolean existsByName(String name) {
        return genreRepository.existsByName(name);
    }
}
