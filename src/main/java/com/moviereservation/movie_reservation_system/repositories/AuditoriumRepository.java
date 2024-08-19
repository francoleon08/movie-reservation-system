package com.moviereservation.movie_reservation_system.repositories;

import com.moviereservation.movie_reservation_system.models.cinema.Auditoriums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditoriums, String> {
}
