package com.inc.repository;

import com.inc.entity.Movie;
import com.inc.enums.MovieState;
import com.inc.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
    Optional<Movie> findByName(String name);

    //Write a derived query to list all movies between a range of prices
    List<Movie> getAllByPriceBetween(BigDecimal price, BigDecimal price2);

    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> findAllByDurationIn(List<Integer> duration);

    //Write a derived query to list all movies with higher than a specific release date
    List<Movie> getAllByReleaseDateAfter(LocalDate releaseDate);

    //Write a derived query to list all movies with a specific state and type
    List<Movie> getAllByStateAndType(MovieState state, MovieType type);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
    @Query("SELECT m FROM Movie m WHERE m.price BETWEEN :low AND :high")
    List<Movie> movieBetweenPriceRange(BigDecimal low, BigDecimal high);

    //Write a JPQL query that returns all movie names
    @Query("SELECT m.name FROM Movie m")
    List<String> listOfAllMovieNames();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name


    //Write a native query that return the list of movies in a specific range of prices

    //Write a native query to return all movies where duration exists in the range of duration

    //Write a native query to list the top 5 most expensive movies

}