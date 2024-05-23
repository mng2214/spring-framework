package com.inc.repository;

import com.inc.entity.Course;
import com.inc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course, Long> {

    //find all courses by category
    List<Course> findByName (String courseName);

    //find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName (String categoryName);

    //checks if a course with the provided name exists. return true if the course exists, false otherwise
    Boolean existsByName (String courseName);

    //returns the count of courses for the provided category
    Integer countByCategory (String categoryName);

    //find all courses that start with the provided course name
    List<Course> findByNameStartingWith (String categoryName);

    //find all courses by category and returns a stream
    Stream<Course> findByCategory (String categoryName);

    @Query("Select c from  Course c where c.category = :category and c.rating > :rating ") // positional param
    List<Course> findAllByCategoryAndRatingGreaterThen (@Param("category") String category, @Param("rating") int rating);



}
