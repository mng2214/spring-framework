package com.inc.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class MovieCinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieCinemaId;

    //cinema id

    @OneToMany(mappedBy = "movieId") // in one to many relationship ownership belongs to Many side
    private List<Movie> movie;

    private LocalDate dateTime;
}
