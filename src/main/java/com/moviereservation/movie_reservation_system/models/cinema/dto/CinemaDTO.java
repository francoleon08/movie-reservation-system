package com.moviereservation.movie_reservation_system.models.cinema.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CinemaDTO {
    protected String id;
    protected String name;
    protected String address;
    protected String postalCodeCity;
}
