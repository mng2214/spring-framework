package com.inc.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cinema extends BaseEntity{

    private String name;
    private String sponsoredName;

    private Location location;
}
