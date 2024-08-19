package com.moviereservation.movie_reservation_system.models.cinema;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityDTO {
    private String postalCode;
    private String name;
}
