package com.moviereservation.movie_reservation_system.exceptions;

public class ResourceAlreadyExistException extends Exception {
    public ResourceAlreadyExistException(String message) {
        super(message);
    }
}
