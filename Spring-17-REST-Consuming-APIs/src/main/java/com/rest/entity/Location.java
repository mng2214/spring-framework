package com.rest.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Location extends BaseEntity {

    private String name;
    private BigDecimal latitude;
    private BigDecimal langitude;
    private String postalCode;
    private String country;
    private String state;
    private String city;
    private String address;

}
