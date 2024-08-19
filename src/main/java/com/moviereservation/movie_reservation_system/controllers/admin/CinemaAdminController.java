package com.moviereservation.movie_reservation_system.controllers.admin;

import com.moviereservation.movie_reservation_system.exceptions.ResourceNotFoundException;
import com.moviereservation.movie_reservation_system.models.cinema.dto.CinemaDTO;
import com.moviereservation.movie_reservation_system.services.CinemaService;
import com.moviereservation.movie_reservation_system.utils.ConvertTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/cinema")
public class CinemaAdminController {

    @Autowired
    private CinemaService cinemaService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{cinemaId}")
    public ResponseEntity<?> getCinema(@PathVariable("cinemaId") String cinemaId) {
        try {
            return ResponseEntity.ok(ConvertTO.convertToResponseCinemaDTO(
                    cinemaService.getCinema(cinemaId)
            ));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> addCinema(@RequestBody CinemaDTO cinema) {
        try {
            return ResponseEntity.ok(cinemaService.addCinema(cinema));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<?> updateCinema(@RequestBody CinemaDTO cinema) {
        try {
            return ResponseEntity.ok(ConvertTO.convertToResponseCinemaDTO(
                    cinemaService.updateCinema(cinema)
            ));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{cinemaId}")
    public ResponseEntity<?> deleteCinema(@PathVariable("cinemaId") String cinemaId) {
        try {
            cinemaService.deleteCinema(cinemaId);
            return ResponseEntity.ok("Cinema deleted successfully");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
