package com.moviereservation.movie_reservation_system.repositories;

import com.moviereservation.movie_reservation_system.models.movies.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {


}
