package com.bob_R.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
@NoArgsConstructor
@Data
public class Region extends com.bob_R.entity.BaseEntity {

    private String region;
    private String country;
}

