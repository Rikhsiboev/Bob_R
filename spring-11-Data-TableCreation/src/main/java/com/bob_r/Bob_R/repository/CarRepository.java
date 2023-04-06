package com.bob_r.Bob_R.repository;

import com.bob_r.Bob_R.entity.Car;

import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface CarRepository extends JpaRepository<Car,Long> {


}
