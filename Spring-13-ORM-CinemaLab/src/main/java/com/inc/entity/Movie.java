package com.inc.entity;

import com.inc.enums.MovieType;
import com.inc.enums.MovieState;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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

    @ManyToMany
    private List<Genre> genreList;

//    @ManyToOne
//    private MovieCinema movieCinema;

}
