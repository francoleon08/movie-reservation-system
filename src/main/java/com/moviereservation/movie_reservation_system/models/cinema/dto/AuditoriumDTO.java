package com.moviereservation.movie_reservation_system.models.cinema.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuditoriumDTO {
    private String id;
    private String name;
    private int capacity;
    private int rowsNumber;
    private String type;
    private String cinemaId;
}
