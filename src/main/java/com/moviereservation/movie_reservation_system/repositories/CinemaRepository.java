package com.moviereservation.movie_reservation_system.repositories;

import com.moviereservation.movie_reservation_system.models.cinema.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, String> {
}
