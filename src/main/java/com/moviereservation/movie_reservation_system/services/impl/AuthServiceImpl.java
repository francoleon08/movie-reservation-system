package com.moviereservation.movie_reservation_system.services.impl;

import com.moviereservation.movie_reservation_system.models.user.dto.UserDetailsDTO;
import com.moviereservation.movie_reservation_system.security.jwt.JwtService;
import com.moviereservation.movie_reservation_system.models.user.User;
import com.moviereservation.movie_reservation_system.models.user.UserRole;
import com.moviereservation.movie_reservation_system.models.user.dto.AuthResponse;
import com.moviereservation.movie_reservation_system.models.user.dto.LoginDTO;
import com.moviereservation.movie_reservation_system.models.user.dto.RegisterDTO;
import com.moviereservation.movie_reservation_system.repositories.UserRepository;
import com.moviereservation.movie_reservation_system.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private JwtService jwtService;

    @Override
    public AuthResponse registerUser(RegisterDTO registerDTO) {
        User user = User.builder()
                .username(registerDTO.getUsername())
                .email(registerDTO.getEmail())
                .hashedPassword(passwordEncoder.encode(registerDTO.getPassword()))
                .firstName(registerDTO.getFirstName())
                .lastName(registerDTO.getLastName())
                .age(registerDTO.getAge())
                .role(UserRole.USER)
                .createdAt(LocalDateTime.now())
                .build();
        userRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.generateToken(user))
                .build();
    }

    @Override
    public AuthResponse loginUser(LoginDTO loginDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
        User user = userRepository.findByUsername(loginDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        String token = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public String logoutUser() {
        return null;
    }

    @Override
    public UserDetailsDTO getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("No user is currently authenticated");
        }
        User user = (User) authentication.getPrincipal();
        return UserDetailsDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .role(user.getRole().toString())
                .build();
    }
}
