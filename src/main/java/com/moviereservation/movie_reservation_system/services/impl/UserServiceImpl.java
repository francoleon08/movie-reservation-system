package com.moviereservation.movie_reservation_system.services.impl;

import com.moviereservation.movie_reservation_system.repositories.UserRepository;
import com.moviereservation.movie_reservation_system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
}
