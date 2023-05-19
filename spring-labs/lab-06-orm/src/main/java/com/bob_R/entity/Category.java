package com.bob_R.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category extends BaseEntity {

    private String name;

}
