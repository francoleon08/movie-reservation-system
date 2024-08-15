package com.moviereservation.movie_reservation_system.models.movies.dto;

import com.moviereservation.movie_reservation_system.models.movies.Genre;
import com.moviereservation.movie_reservation_system.models.movies.Language;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class MovieDTO {

    private String id;
    private String name;
    private String synopsis;
    private String director;
    private String nationality;
    private String qualification;
    private String distributor;
    private String trailerUrl;
    private String posterUrl;
    private String website;
    private LocalDate releaseDate;
    private int duration;
    private List<String> genres;
    private List<String> languages;
    private List<String> actors;
}
