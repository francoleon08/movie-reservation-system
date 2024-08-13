package com.moviereservation.movie_reservation_system.models.cinema;

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
public class City {

    @Id
    private String postalCode;
    @Column(nullable = false, length = 100)
    private String name;


    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cinema> cinemas;
}
