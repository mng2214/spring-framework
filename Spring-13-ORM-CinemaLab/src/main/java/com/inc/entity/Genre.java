package com.inc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Genre extends BaseEntity {
    private String name;

    @ManyToMany(mappedBy = "genreList")
    private List<Movie> movieList;
}
