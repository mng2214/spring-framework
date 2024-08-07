package com.rest.restjackson.controller;


import com.rest.restjackson.entity.Cinema;
import com.rest.restjackson.repository.CinemaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Cinema", description = "Cinema CRUD Operations")
@AllArgsConstructor
public class CinemaController {

    private final CinemaRepository cinemaRepository;

    @GetMapping("/cinemas")
    @Operation(summary = "Read all cinemas")
    public List<Cinema> readAllCinemas(){
        return cinemaRepository.findAll();
    }
}