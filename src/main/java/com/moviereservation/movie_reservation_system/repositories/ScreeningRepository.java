package com.moviereservation.movie_reservation_system.repositories;

import com.moviereservation.movie_reservation_system.models.screening.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
}
