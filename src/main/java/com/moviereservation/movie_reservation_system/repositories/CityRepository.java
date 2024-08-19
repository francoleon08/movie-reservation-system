package com.moviereservation.movie_reservation_system.repositories;

import com.moviereservation.movie_reservation_system.models.cinema.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
}
