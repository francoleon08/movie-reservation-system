package com.moviereservation.movie_reservation_system.services;

import com.moviereservation.movie_reservation_system.exceptions.ResourceAlreadyExistException;
import com.moviereservation.movie_reservation_system.exceptions.ResourceNotFoundException;
import com.moviereservation.movie_reservation_system.models.cinema.Auditoriums;
import com.moviereservation.movie_reservation_system.models.cinema.dto.AuditoriumDTO;

public interface AuditoriumService {

    Auditoriums getAuditorium(String id) throws ResourceNotFoundException;
    Auditoriums addAuditorium(AuditoriumDTO auditorium) throws ResourceAlreadyExistException, ResourceNotFoundException;
    Auditoriums updateAuditorium(AuditoriumDTO auditorium) throws ResourceNotFoundException;
    void deleteAuditorium(String id) throws ResourceNotFoundException;
}
