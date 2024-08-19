package com.moviereservation.movie_reservation_system.services.impl;

import com.moviereservation.movie_reservation_system.exceptions.ResourceAlreadyExistException;
import com.moviereservation.movie_reservation_system.exceptions.ResourceNotFoundException;
import com.moviereservation.movie_reservation_system.models.movies.Genre;
import com.moviereservation.movie_reservation_system.models.movies.Language;
import com.moviereservation.movie_reservation_system.models.movies.Movie;
import com.moviereservation.movie_reservation_system.models.movies.MovieState;
import com.moviereservation.movie_reservation_system.models.movies.dto.MovieDTO;
import com.moviereservation.movie_reservation_system.repositories.MovieRepository;
import com.moviereservation.movie_reservation_system.services.GenreService;
import com.moviereservation.movie_reservation_system.services.LanguageService;
import com.moviereservation.movie_reservation_system.services.MovieService;
import com.moviereservation.movie_reservation_system.utils.ConvertTO;
import com.moviereservation.movie_reservation_system.utils.MovieSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private GenreService genreService;
    @Autowired
    private LanguageService languageService;

    @Override
    public Movie getMovieById(String id) throws ResourceNotFoundException {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
    }

    @Override
    public List<Movie> findMoviesByOptionalParams(String name, String director, String nationality, String qualification, String distributor, String genre, String language, String actor) throws ResourceNotFoundException {
        Specification<Movie> specification = Specification
                .where(MovieSpecification.hasName(name))
                .and(MovieSpecification.hasDirector(director))
                .and(MovieSpecification.hasNationality(nationality))
                .and(MovieSpecification.hasQualification(qualification))
                .and(MovieSpecification.hasDistributor(distributor))
                .and(MovieSpecification.hasGenre(genre))
                .and(MovieSpecification.hasLanguage(language))
                .and(MovieSpecification.hasActor(actor));
        List<Movie> movies = movieRepository.findAll(specification);
        movies.removeIf(movie -> movie.getState().equals(MovieState.INACTIVE));
        if (movies.isEmpty()) {
            throw new ResourceNotFoundException("No movies found");
        }
        return movies;
    }

    @Override
    public Movie addMovie(MovieDTO movieDTO) throws ResourceAlreadyExistException {
        if (movieRepository.existsById(movieDTO.getId())) {
            throw new ResourceAlreadyExistException("Movie already exists");
        }
        Movie movie = ConvertTO.convertToMovie(movieDTO);
        handleLanguages(movieDTO, movie);
        handleGenres(movieDTO, movie);
        movie.setState(MovieState.ACTIVE);
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(String id, MovieDTO movie) throws ResourceNotFoundException {
        if (!movieRepository.existsById(id)) {
            throw new ResourceNotFoundException("Movie not found");
        }
        Movie movieToUpdate = ConvertTO.convertToMovie(movie);
        handleLanguages(movie, movieToUpdate);
        handleGenres(movie, movieToUpdate);
        return movieRepository.save(movieToUpdate);
    }

    @Override
    public void deleteMovie(String id) throws ResourceNotFoundException {
        if (!movieRepository.existsById(id)) {
            throw new ResourceNotFoundException("Movie not found");
        }
        movieRepository.deleteById(id);
    }

    @Override
    public void deactivateMovie(String id) throws ResourceNotFoundException {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
        movie.setState(MovieState.INACTIVE);
        movieRepository.save(movie);
    }

    private void handleGenres(MovieDTO movieDTO, Movie movie) {
        List<Genre> genres = movieDTO.getGenres().stream()
                .map(this::handleGenresException)
                .collect(Collectors.toList());
        movie.setGenres(genres);
    }

    private Genre handleGenresException(String genreName) {
        try {
            return genreService.findByName(genreName);
        } catch (ResourceNotFoundException e) {
            return ConvertTO.createGenre(genreName);
        }
    }

    private void handleLanguages(MovieDTO movieDTO, Movie movie) {
        List<Language> languages = movieDTO.getLanguages().stream()
                .map(this::handleLanguageException)
                .collect(Collectors.toList());
        movie.setLanguages(languages);
    }

    private Language handleLanguageException(String languageName) {
        try {
            return languageService.findByName(languageName);
        } catch (ResourceNotFoundException e) {
            return ConvertTO.createLanguage(languageName);
        }
    }
}
