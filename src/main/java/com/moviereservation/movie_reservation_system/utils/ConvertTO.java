package com.moviereservation.movie_reservation_system.utils;

import com.moviereservation.movie_reservation_system.models.cinema.*;
import com.moviereservation.movie_reservation_system.models.cinema.dto.AuditoriumDTO;
import com.moviereservation.movie_reservation_system.models.cinema.dto.ResponseCinemaDTO;
import com.moviereservation.movie_reservation_system.models.cinema.dto.ResponseCityDTO;
import com.moviereservation.movie_reservation_system.models.movies.Genre;
import com.moviereservation.movie_reservation_system.models.movies.Language;
import com.moviereservation.movie_reservation_system.models.movies.Movie;
import com.moviereservation.movie_reservation_system.models.movies.dto.MovieDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertTO {

    public static Movie convertToMovie(MovieDTO movie) {
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

    public static List<MovieDTO> convertToMovieDTOList(List<Movie> movies) {
        return movies.stream().map(ConvertTO::convertToMovieDTO).collect(Collectors.toList());
    }

    public static MovieDTO convertToMovieDTO(Movie movie) {
        return MovieDTO.builder()
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
                .genres(movie.getGenres().stream().map(Genre::getName).collect(Collectors.toList()))
                .languages(movie.getLanguages().stream().map(Language::getName).collect(Collectors.toList()))
                .actors(movie.getActors())
                .build();
    }

    public static ResponseCityDTO convertToResponseCityDTO(City city) {
        return ResponseCityDTO.builder()
                .postalCode(city.getPostalCode())
                .name(city.getName())
                .cinemas(city.getCinemas().stream().map(Cinema::getName).collect(Collectors.toList()))
                .build();
    }

    public static ResponseCinemaDTO convertToResponseCinemaDTO(Cinema cinema) {
        return ResponseCinemaDTO.builder()
                .id(cinema.getId())
                .name(cinema.getName())
                .address(cinema.getAddress())
                .postalCodeCity(cinema.getCity().getPostalCode())
                .auditoriums(cinema.getAuditoriums().stream().map(Auditoriums::getName).collect(Collectors.toList()))
                .build();
    }

    public static AuditoriumDTO convertToAuditoriumDTO(Auditoriums auditoriums){
        return AuditoriumDTO.builder()
                .id(auditoriums.getId())
                .name(auditoriums.getName())
                .capacity(auditoriums.getCapacity())
                .rowsNumber(auditoriums.getRowsNumber())
                .type(auditoriums.getType())
                .cinemaId(auditoriums.getCinema().getId())
                .build();
    }
}

