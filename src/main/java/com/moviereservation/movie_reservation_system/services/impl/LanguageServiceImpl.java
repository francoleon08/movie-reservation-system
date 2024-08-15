package com.moviereservation.movie_reservation_system.services.impl;

import com.moviereservation.movie_reservation_system.exceptions.ResourceNotFoundException;
import com.moviereservation.movie_reservation_system.models.movies.Language;
import com.moviereservation.movie_reservation_system.repositories.LanguageRepository;
import com.moviereservation.movie_reservation_system.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public Language findByName(String name) throws ResourceNotFoundException {
        return languageRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found"));
    }

    @Override
    public boolean existsByName(String name) {
        return languageRepository.existsByName(name);
    }
}
