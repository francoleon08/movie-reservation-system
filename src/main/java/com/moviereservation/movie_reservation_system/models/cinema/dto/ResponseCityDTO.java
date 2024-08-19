package com.moviereservation.movie_reservation_system.models.cinema.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class ResponseCityDTO extends CityDTO {
    protected List<String> cinemas;
}
