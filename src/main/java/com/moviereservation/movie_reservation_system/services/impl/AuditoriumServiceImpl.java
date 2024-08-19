package com.moviereservation.movie_reservation_system.services.impl;

import com.moviereservation.movie_reservation_system.exceptions.ResourceAlreadyExistException;
import com.moviereservation.movie_reservation_system.exceptions.ResourceNotFoundException;
import com.moviereservation.movie_reservation_system.models.cinema.Auditoriums;
import com.moviereservation.movie_reservation_system.models.cinema.dto.AuditoriumDTO;
import com.moviereservation.movie_reservation_system.repositories.AuditoriumRepository;
import com.moviereservation.movie_reservation_system.services.AuditoriumService;
import com.moviereservation.movie_reservation_system.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {

    @Autowired
    private AuditoriumRepository auditoriumRepository;
    @Autowired
    private CinemaService cinemaService;

    @Override
    public Auditoriums getAuditorium(String id) throws ResourceNotFoundException {
        return auditoriumRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Auditorium not found"));
    }

    @Override
    public Auditoriums addAuditorium(AuditoriumDTO auditorium) throws ResourceAlreadyExistException, ResourceNotFoundException {
        if (auditoriumRepository.existsById(auditorium.getId())) {
            throw new ResourceAlreadyExistException("Auditorium already exists");
        }
        return auditoriumRepository.save(Auditoriums.builder()
                .id(auditorium.getId())
                .name(auditorium.getName())
                .capacity(auditorium.getCapacity())
                .rowsNumber(auditorium.getRowsNumber())
                .type(auditorium.getType())
                .cinema(cinemaService.getCinema(auditorium.getCinemaId()))
                .build());
    }

    @Override
    public Auditoriums updateAuditorium(AuditoriumDTO auditorium) throws ResourceNotFoundException {
        Auditoriums auditoriumToUpdate = getAuditorium(auditorium.getId());
        auditoriumToUpdate.setName(auditorium.getName());
        auditoriumToUpdate.setCapacity(auditorium.getCapacity());
        auditoriumToUpdate.setRowsNumber(auditorium.getRowsNumber());
        auditoriumToUpdate.setType(auditorium.getType());
        auditoriumToUpdate.setCinema(cinemaService.getCinema(auditorium.getCinemaId()));
        return auditoriumRepository.save(auditoriumToUpdate);
    }

    @Override
    public void deleteAuditorium(String id) throws ResourceNotFoundException {
        Auditoriums auditorium = getAuditorium(id);
        auditoriumRepository.delete(auditorium);
    }
}
