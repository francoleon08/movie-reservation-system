package com.moviereservation.movie_reservation_system.services.impl;

import com.moviereservation.movie_reservation_system.exceptions.ResourceAlreadyExistException;
import com.moviereservation.movie_reservation_system.exceptions.ResourceNotFoundException;
import com.moviereservation.movie_reservation_system.models.cinema.Cinema;
import com.moviereservation.movie_reservation_system.models.cinema.dto.CinemaDTO;
import com.moviereservation.movie_reservation_system.repositories.CinemaRepository;
import com.moviereservation.movie_reservation_system.services.CinemaService;
import com.moviereservation.movie_reservation_system.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private CityService cityService;

    @Override
    public Cinema getCinema(String id) throws ResourceNotFoundException {
        return cinemaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cinema not found"));
    }

    @Override
    public Cinema addCinema(CinemaDTO cinema) throws ResourceAlreadyExistException, ResourceNotFoundException {
        if (cinemaRepository.existsById(cinema.getId())) {
            throw new ResourceAlreadyExistException("Cinema already exists");
        }
        return cinemaRepository.save(Cinema.builder()
                .id(cinema.getId())
                .name(cinema.getName())
                .address(cinema.getAddress())
                .city(cityService.getCity(cinema.getPostalCodeCity()))
                .build());
    }

    @Override
    public Cinema updateCinema(CinemaDTO cinema) throws ResourceNotFoundException {
        Cinema cinemaToUpdate = getCinema(cinema.getId());
        cinemaToUpdate.setName(cinema.getName());
        cinemaToUpdate.setAddress(cinema.getAddress());
        cinemaToUpdate.setCity(cityService.getCity(cinema.getPostalCodeCity()));
        return cinemaRepository.save(cinemaToUpdate);
    }

    @Override
    public void deleteCinema(String id) throws ResourceNotFoundException {
       Cinema cinema = getCinema(id);
       cinemaRepository.delete(cinema);
    }
}
