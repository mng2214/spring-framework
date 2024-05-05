package com.inc.model;

import com.inc.enums.MovieType;
import com.inc.enums.MovieState;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Movie extends BaseEntity {

    private String name;
    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;
    private int duration;
    @Column(columnDefinition = "text")
    private String summary;
    @Enumerated(EnumType.STRING)
    private MovieType movieType;
    @Enumerated(EnumType.STRING)
    private MovieState movieState;
    private BigDecimal price;

    @ManyToOne
    private MovieCinema movieCinema;

    public Movie(String name, LocalDate releaseDate, int duration, String summary, MovieType movieType, MovieState movieState, BigDecimal price) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.summary = summary;
        this.movieType = movieType;
        this.movieState = movieState;
        this.price = price;
    }
}
