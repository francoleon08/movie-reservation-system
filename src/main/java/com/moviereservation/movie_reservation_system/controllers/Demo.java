package com.moviereservation.movie_reservation_system.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Demo {

    @GetMapping("/demo")
    public String demo() {
        return "demo";
    }
}
