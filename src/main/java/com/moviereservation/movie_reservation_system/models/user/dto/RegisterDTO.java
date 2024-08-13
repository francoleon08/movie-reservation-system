package com.moviereservation.movie_reservation_system.models.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterDTO {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Integer age;
    private String password;
}
