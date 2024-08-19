package com.moviereservation.movie_reservation_system.services.impl;

import com.moviereservation.movie_reservation_system.exceptions.ResourceAlreadyExistException;
import com.moviereservation.movie_reservation_system.exceptions.ResourceNotFoundException;
import com.moviereservation.movie_reservation_system.models.cinema.City;
import com.moviereservation.movie_reservation_system.models.cinema.dto.CityDTO;
import com.moviereservation.movie_reservation_system.repositories.CityRepository;
import com.moviereservation.movie_reservation_system.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City getCity(String postalCode) throws ResourceNotFoundException {
        return cityRepository.findById(postalCode)
                .orElseThrow(() -> new ResourceNotFoundException("City not found"));
    }

    @Override
    public City addCity(CityDTO city) throws ResourceAlreadyExistException {
        if (cityRepository.existsById(city.getPostalCode())) {
            throw new ResourceAlreadyExistException("City already exists");
        }
        return cityRepository.save(City.builder()
                .postalCode(city.getPostalCode())
                .name(city.getName())
                .build());
    }

    @Override
    public City updateCity(String postalCode, String name) throws ResourceNotFoundException {
        City city = cityRepository.findById(postalCode)
                .orElseThrow(() -> new ResourceNotFoundException("City not found"));
        city.setName(name);
        return cityRepository.save(city);
    }

    @Override
    public void deleteCity(String postalCode) throws ResourceNotFoundException {
        City city = cityRepository.findById(postalCode)
                .orElseThrow(() -> new ResourceNotFoundException("City not found"));
        cityRepository.delete(city);
    }
}
