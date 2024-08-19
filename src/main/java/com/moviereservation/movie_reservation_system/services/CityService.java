package com.moviereservation.movie_reservation_system.services;

import com.moviereservation.movie_reservation_system.exceptions.ResourceAlreadyExistException;
import com.moviereservation.movie_reservation_system.exceptions.ResourceNotFoundException;
import com.moviereservation.movie_reservation_system.models.cinema.City;
import com.moviereservation.movie_reservation_system.models.cinema.dto.CityDTO;

public interface CityService {

    City getCity(String postalCode) throws ResourceNotFoundException;
    City addCity(CityDTO city) throws ResourceAlreadyExistException;
    City updateCity(String postalCode, String name) throws ResourceNotFoundException;
    void deleteCity(String postalCode) throws ResourceNotFoundException;
}
