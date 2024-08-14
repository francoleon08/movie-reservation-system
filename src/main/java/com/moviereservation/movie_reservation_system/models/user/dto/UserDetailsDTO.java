package com.moviereservation.movie_reservation_system.models.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetailsDTO {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Integer age;
    private String role;
}
