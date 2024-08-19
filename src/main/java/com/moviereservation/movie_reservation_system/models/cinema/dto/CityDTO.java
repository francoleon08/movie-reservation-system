package com.moviereservation.movie_reservation_system.models.cinema.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CityDTO {
    protected String postalCode;
    protected String name;
}
