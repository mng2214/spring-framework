package com.inc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cinema extends BaseEntity{

    private String name;
    private String sponsoredName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

}
