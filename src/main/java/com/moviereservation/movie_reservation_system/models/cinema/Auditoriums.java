package com.moviereservation.movie_reservation_system.models.cinema;

import com.moviereservation.movie_reservation_system.models.screening.Screening;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Auditoriums {

    @Id
    private String id;
    @Column(nullable = false, length = 100)
    private String name;
    private int capacity;
    private int rowsNumber;
    @Column(nullable = false, length = 50)
    private String type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cinema_id", nullable = false)
    private Cinema cinema;

    @OneToMany(mappedBy = "auditoriums", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Screening> screenings;
}
