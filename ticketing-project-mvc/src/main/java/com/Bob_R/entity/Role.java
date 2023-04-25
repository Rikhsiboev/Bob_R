package com.Bob_R.entity;

import lombok.*;

import javax.naming.Name;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    private String description;
}
