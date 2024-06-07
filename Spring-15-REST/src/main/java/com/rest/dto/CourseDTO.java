package com.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CourseDTO {

    private Long id;
    private String name;
    private String category;
    private int rating;
    private String description;

}
