package com.moviereservation.movie_reservation_system.controllers.admin;

import com.moviereservation.movie_reservation_system.models.cinema.dto.AuditoriumDTO;
import com.moviereservation.movie_reservation_system.services.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/auditorium")
public class AuditoriumAdminController {

    @Autowired
    private AuditoriumService auditoriumService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{auditoriumId}")
    public ResponseEntity<?> getAuditorium(@PathVariable("auditoriumId") String auditoriumId) {
        try {
            return ResponseEntity.ok(auditoriumService.getAuditorium(auditoriumId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> addAuditorium(@RequestBody AuditoriumDTO auditorium) {
        try {
            return ResponseEntity.ok(auditoriumService.addAuditorium(auditorium));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<?> updateAuditorium(@RequestBody AuditoriumDTO auditorium) {
        try {
            return ResponseEntity.ok(auditoriumService.updateAuditorium(auditorium));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{auditoriumId}")
    public ResponseEntity<?> deleteAuditorium(@PathVariable("auditoriumId") String auditoriumId) {
        try {
            auditoriumService.deleteAuditorium(auditoriumId);
            return ResponseEntity.ok("Auditorium deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
