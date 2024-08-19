package com.moviereservation.movie_reservation_system.controllers.admin;

import com.moviereservation.movie_reservation_system.models.screening.dto.ScreeningDTO;
import com.moviereservation.movie_reservation_system.services.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin/schedule")
public class ScheduleAdminController {

    @Autowired
    private ScreeningService screeningService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> addScreening(@RequestBody ScreeningDTO screeningDTO) {
        try {
            screeningService.addScreening(screeningDTO);
            return ResponseEntity.ok("Screening added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
