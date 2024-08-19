package com.moviereservation.movie_reservation_system.services;

import com.moviereservation.movie_reservation_system.exceptions.ResourceNotFoundException;
import com.moviereservation.movie_reservation_system.models.screening.Screening;
import com.moviereservation.movie_reservation_system.models.screening.dto.ScreeningDTO;

public interface ScreeningService {

    Screening addScreening(ScreeningDTO screening) throws ResourceNotFoundException;
}
