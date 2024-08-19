package com.moviereservation.movie_reservation_system.repositories;

import com.moviereservation.movie_reservation_system.models.movies.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

    Optional<Language> findByName(String name);

    boolean existsByName(String name);
}
