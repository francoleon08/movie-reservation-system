package com.moviereservation.movie_reservation_system.models.screening.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ScreeningDTO {
    private String movieId;
    private String auditoriumId;
    private LocalDate projectionDate;
    private LocalTime projectionTime;
    private String format;
    private Double price;
}
