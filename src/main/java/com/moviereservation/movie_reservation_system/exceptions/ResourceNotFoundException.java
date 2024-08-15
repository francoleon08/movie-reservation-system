package com.moviereservation.movie_reservation_system.exceptions;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
