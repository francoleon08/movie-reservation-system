package com.moviereservation.movie_reservation_system.services;

import com.moviereservation.movie_reservation_system.models.user.dto.AuthResponse;
import com.moviereservation.movie_reservation_system.models.user.dto.LoginDTO;
import com.moviereservation.movie_reservation_system.models.user.dto.RegisterDTO;
import com.moviereservation.movie_reservation_system.models.user.dto.UserDetailsDTO;

public interface AuthService {

    AuthResponse registerUser(RegisterDTO registerDTO);

    AuthResponse loginUser(LoginDTO loginDTO);

    UserDetailsDTO getCurrentUser();
}
