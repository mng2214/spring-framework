package com.rest.controller;

import com.rest.entity.MovieCinema;
import com.rest.repository.GenreRepository;
import com.rest.repository.MovieCinemaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Consume_WebClient {

    private final MovieCinemaRepository movieCinemaRepository;
    private final GenreRepository genreRepository;

    public Consume_WebClient(MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
        this.genreRepository = genreRepository;
    }

    @GetMapping("/flux-movie-cinemas")
    public Flux<MovieCinema> fluxMovieCinema() {
        return Flux.fromIterable(movieCinemaRepository.findAll());
    }

//    @GetMapping("/mono-movie-cinema/{id}")
//    public Mono<MovieCinema> readById (@PathVariable("id") Long id) {
//        return Mono.just(movieCinemaRepository.findById(id).get());
//    }

    @GetMapping("/mono-movie-cinema/{id}")
    public ResponseEntity<Mono<MovieCinema>>  readById (@PathVariable("id") Long id) {
        return ResponseEntity.ok(Mono.just(movieCinemaRepository.findById(id).get()));
    }





}
