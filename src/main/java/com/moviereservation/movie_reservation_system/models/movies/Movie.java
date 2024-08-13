package com.moviereservation.movie_reservation_system.models.movies;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.moviereservation.movie_reservation_system.models.screening.Screening;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    private String synopsis;
    private String director;
    private String nationality;
    private String qualification;
    private Integer duration;
    private String distributor;
    private String trailerUrl;
    private String posterUrl;
    private String website;
    private LocalDate releaseDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    @JsonManagedReference
    private List<Genre> genres;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "movie_language",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    @JsonManagedReference
    private List<Language> languages;

    @ElementCollection (fetch = FetchType.EAGER)
    @CollectionTable(
            name = "movie_cast",
            joinColumns = @JoinColumn(name = "movie_id")
    )
    @Column(name = "actor")
    private List<String> actors;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Screening> screenings;
}
