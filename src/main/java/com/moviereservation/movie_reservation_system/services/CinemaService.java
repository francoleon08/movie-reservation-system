package com.moviereservation.movie_reservation_system.services;

import com.moviereservation.movie_reservation_system.exceptions.ResourceAlreadyExistException;
import com.moviereservation.movie_reservation_system.exceptions.ResourceNotFoundException;
import com.moviereservation.movie_reservation_system.models.cinema.Cinema;
import com.moviereservation.movie_reservation_system.models.cinema.dto.CinemaDTO;

public interface CinemaService {
    Cinema getCinema(String id) throws ResourceNotFoundException;
    Cinema addCinema(CinemaDTO cinema) throws ResourceAlreadyExistException, ResourceNotFoundException;
    Cinema updateCinema(CinemaDTO cinema) throws ResourceNotFoundException;
    void deleteCinema(String id) throws ResourceNotFoundException;
}
