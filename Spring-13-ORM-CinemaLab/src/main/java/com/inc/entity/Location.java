package com.inc.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Location extends BaseEntity{
    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private String state;
}
