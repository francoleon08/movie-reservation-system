package com.moviereservation.movie_reservation_system.models.cinema.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CinemaDTO {
    private String id;
    private String name;
    private String address;
    private String postalCodeCity;
}
