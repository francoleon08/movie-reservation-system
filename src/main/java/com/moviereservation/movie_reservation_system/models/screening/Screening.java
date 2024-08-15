package com.moviereservation.movie_reservation_system.models.screening;

import com.moviereservation.movie_reservation_system.models.cinema.Auditoriums;
import com.moviereservation.movie_reservation_system.models.movies.Movie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate projectionDate;
    @Column(nullable = false)
    private LocalTime projectionTime;
    @Column(nullable = false, length = 10)
    private String format;
    private int reservedSeats;
    private int totalSeats;
    private int availableSeats;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "auditoriums_id", nullable = false)
    private Auditoriums auditoriums;

    @OneToMany(mappedBy = "screening", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}
