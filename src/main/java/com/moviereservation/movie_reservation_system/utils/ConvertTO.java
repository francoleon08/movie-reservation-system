package com.moviereservation.movie_reservation_system.utils;

import com.moviereservation.movie_reservation_system.models.movies.Genre;
import com.moviereservation.movie_reservation_system.models.movies.Language;
import com.moviereservation.movie_reservation_system.models.movies.Movie;
import com.moviereservation.movie_reservation_system.models.movies.dto.MovieDTO;

import java.util.stream.Collectors;

public class ConvertTO {

    public static Movie convertToMovieDTO(MovieDTO movie) {
        return Movie.builder()
                .id(movie.getId())
                .name(movie.getName())
                .synopsis(movie.getSynopsis())
                .director(movie.getDirector())
                .nationality(movie.getNationality())
                .qualification(movie.getQualification())
                .distributor(movie.getDistributor())
                .trailerUrl(movie.getTrailerUrl())
                .posterUrl(movie.getPosterUrl())
                .website(movie.getWebsite())
                .releaseDate(movie.getReleaseDate())
                .duration(movie.getDuration())
                .genres(movie.getGenres().stream().map(ConvertTO::createGenre).collect(Collectors.toList()))
                .languages(movie.getLanguages().stream().map(ConvertTO::createLanguage).collect(Collectors.toList()))
                .actors(movie.getActors())
                .build();
    }

    public static Genre createGenre(String genre) {
        return Genre.builder().name(genre).build();
    }

    public static Language createLanguage(String language) {
        return Language.builder().name(language).build();
    }
}

