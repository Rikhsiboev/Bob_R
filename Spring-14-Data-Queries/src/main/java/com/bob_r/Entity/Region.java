package com.bob_r.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
@NoArgsConstructor
@Data
public class Region extends com.bob_r.entity.BaseEntity {

    private String region;
    private String country;
}

