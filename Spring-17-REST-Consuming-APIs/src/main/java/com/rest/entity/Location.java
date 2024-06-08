package com.rest.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Data
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
