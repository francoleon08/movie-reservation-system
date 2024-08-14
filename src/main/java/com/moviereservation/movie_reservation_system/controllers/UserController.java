package com.moviereservation.movie_reservation_system.controllers;

import com.moviereservation.movie_reservation_system.security.jwt.JwtAuthenticationFilter;
import com.moviereservation.movie_reservation_system.security.jwt.JwtService;
import com.moviereservation.movie_reservation_system.services.AuthService;
import com.moviereservation.movie_reservation_system.models.user.dto.LoginDTO;
import com.moviereservation.movie_reservation_system.models.user.dto.RegisterDTO;
import com.moviereservation.movie_reservation_system.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterDTO registerDTO) {
        return ResponseEntity.ok(authService.registerUser(registerDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(authService.loginUser(loginDTO));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        return null;
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser() {
        return ResponseEntity.ok(authService.getCurrentUser());
    }
}
