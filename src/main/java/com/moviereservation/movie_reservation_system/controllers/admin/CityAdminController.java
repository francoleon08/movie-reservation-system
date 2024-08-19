package com.moviereservation.movie_reservation_system.controllers.admin;

import com.moviereservation.movie_reservation_system.exceptions.ResourceNotFoundException;
import com.moviereservation.movie_reservation_system.models.cinema.City;
import com.moviereservation.movie_reservation_system.models.cinema.CityDTO;
import com.moviereservation.movie_reservation_system.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/cities")
public class CityAdminController {

    @Autowired
    private CityService cityService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{postalCode}")
    public ResponseEntity<?> getCity(@PathVariable("postalCode") String postalCode) {
        try {
            return ResponseEntity.ok(cityService.getCity(postalCode));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> addCity(@RequestBody CityDTO city) {
        try {
            return ResponseEntity.ok(cityService.addCity(city));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<?> updateCity(@RequestBody CityDTO city) {
        try {
            return ResponseEntity.ok(cityService.updateCity(city.getPostalCode(), city.getName()));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{postalCode}")
    public ResponseEntity<?> deleteCity(@PathVariable("postalCode") String postalCode) {
        try {
            cityService.deleteCity(postalCode);
            return ResponseEntity.ok("City deleted successfully");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
