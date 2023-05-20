package com.Bob_R.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(BaseEntityListener.class)
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isDeleted = false; // check from db is it deleted or no for all repository

    @Column(nullable = false,updatable = false)
    private LocalDateTime insertDateTime;
    @Column(nullable = false,updatable = false)
    private Long insertUserId;
    @Column(nullable = false)
    private LocalDateTime lastUpdateDateTime;
    @Column(nullable = false)
    private Long lastUpdateUserId;

//
//    @PrePersist // when ever i change in db it weill been created automatic
//    private void onPrePersist(){
//        this.insertDateTime = LocalDateTime.now();
//        this.lastUpdateDateTime=LocalDateTime.now();
//        this.insertUserId=1L;
//        this.lastUpdateUserId=1L;
//    }
//
//    @PreUpdate
//    private void onPreUpdate(){
//        this.lastUpdateDateTime=LocalDateTime.now();
//        this.lastUpdateUserId=1L;
//    }

}
