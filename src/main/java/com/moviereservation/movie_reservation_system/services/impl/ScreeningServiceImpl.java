package com.moviereservation.movie_reservation_system.services.impl;

import com.moviereservation.movie_reservation_system.exceptions.ResourceNotFoundException;
import com.moviereservation.movie_reservation_system.models.cinema.Auditoriums;
import com.moviereservation.movie_reservation_system.models.movies.Movie;
import com.moviereservation.movie_reservation_system.models.screening.Screening;
import com.moviereservation.movie_reservation_system.models.screening.Ticket;
import com.moviereservation.movie_reservation_system.models.screening.dto.ScreeningDTO;
import com.moviereservation.movie_reservation_system.repositories.ScreeningRepository;
import com.moviereservation.movie_reservation_system.services.AuditoriumService;
import com.moviereservation.movie_reservation_system.services.MovieService;
import com.moviereservation.movie_reservation_system.services.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ScreeningServiceImpl implements ScreeningService {

    @Autowired
    private ScreeningRepository screeningRepository;
    @Autowired
    private MovieService movieService;
    @Autowired
    private AuditoriumService auditoriumService;

    @Override
    public Screening addScreening(ScreeningDTO screeningDTO) throws ResourceNotFoundException {
        Movie movie = movieService.getMovieById(screeningDTO.getMovieId());
        Auditoriums auditorium = auditoriumService.getAuditorium(screeningDTO.getAuditoriumId());

        Screening newScreening = buildScreening(screeningDTO, movie, auditorium);
        List<Ticket> tickets = generateTicketsForScreening(auditorium, screeningDTO.getPrice(), newScreening);

        newScreening.setTickets(tickets);
        return screeningRepository.save(newScreening);
    }

    private Screening buildScreening(ScreeningDTO screeningDTO, Movie movie, Auditoriums auditorium) {
        return Screening.builder()
                .projectionDate(screeningDTO.getProjectionDate())
                .projectionTime(screeningDTO.getProjectionTime())
                .format(screeningDTO.getFormat())
                .reservedSeats(0)
                .totalSeats(auditorium.getCapacity())
                .availableSeats(auditorium.getCapacity())
                .movie(movie)
                .auditoriums(auditorium)
                .build();
    }

    private List<Ticket> generateTicketsForScreening(Auditoriums auditorium, double price, Screening screening) {
        int rows = auditorium.getRowsNumber();
        int seatsPerRow = auditorium.getCapacity() / rows;

        return IntStream.range(0, rows)
                .boxed()
                .flatMap(row -> IntStream.range(0, seatsPerRow)
                        .mapToObj(seat -> createTicket(row, seat, price, screening)))
                .collect(Collectors.toList());
    }

    private Ticket createTicket(int row, int seat, double price, Screening screening) {
        return Ticket.builder()
                .price(price)
                .rowNumber(row)
                .seatNumber(seat)
                .isAvailable(true)
                .screening(screening)
                .build();
    }
}
