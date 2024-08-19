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
public class Cinema {

    @Id
    private String id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 60)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Auditoriums> auditoriums;
}
