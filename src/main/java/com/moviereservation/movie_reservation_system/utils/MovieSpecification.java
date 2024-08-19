package com.moviereservation.movie_reservation_system.utils;

import com.moviereservation.movie_reservation_system.models.movies.Genre;
import com.moviereservation.movie_reservation_system.models.movies.Movie;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

public class MovieSpecification {

    public static Specification<Movie> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                name == null ? criteriaBuilder.conjunction() : criteriaBuilder.like(root.get("name"), name);
    }

    public static Specification<Movie> hasDirector(String director) {
        return (root, query, criteriaBuilder) ->
                director == null ? criteriaBuilder.conjunction() : criteriaBuilder.like(root.get("director"), director);
    }

    public static Specification<Movie> hasNationality(String nationality) {
        return (root, query, criteriaBuilder) ->
                nationality == null ? criteriaBuilder.conjunction() : criteriaBuilder.like(root.get("director"), nationality);
    }

    public static Specification<Movie> hasQualification(String qualification) {
        return (root, query, criteriaBuilder) ->
                qualification == null ? criteriaBuilder.conjunction() : criteriaBuilder.like(root.get("qualification"), qualification);
    }

    public static Specification<Movie> hasDistributor(String distributor) {
        return (root, query, criteriaBuilder) ->
                distributor == null ? criteriaBuilder.conjunction() : criteriaBuilder.like(root.get("distributor"), distributor);
    }

    public static Specification<Movie> hasGenre(String genre) {
        return (root, query, criteriaBuilder) -> {
            if (genre == null) {
                return criteriaBuilder.conjunction();
            }
            Join<Movie, Genre> join = root.join("genres", JoinType.INNER);
            return criteriaBuilder.equal(join.get("name"), genre);
        };
    }

    public static Specification<Movie> hasLanguage(String language) {
        return (root, query, criteriaBuilder) -> {
            if (language == null) {
                return criteriaBuilder.conjunction();
            }
            Join<Movie, Genre> join = root.join("languages", JoinType.INNER);
            return criteriaBuilder.equal(join.get("name"), language);
        };
    }

    public static Specification<Movie> hasActor(String actor) {
        return (root, query, criteriaBuilder) -> {
            if (actor == null) {
                return criteriaBuilder.conjunction();
            }
            Join<Movie, String> join = root.join("actors", JoinType.INNER);
            return criteriaBuilder.equal(join.get("name"), actor);
        };
    }
}
