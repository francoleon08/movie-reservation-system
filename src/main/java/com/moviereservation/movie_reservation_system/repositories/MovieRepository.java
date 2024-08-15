package com.moviereservation.movie_reservation_system.repositories;

import com.moviereservation.movie_reservation_system.models.movies.Movie;
import com.moviereservation.movie_reservation_system.models.movies.MovieState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

    Optional<List<Movie>> findAllByState(MovieState state);
}
