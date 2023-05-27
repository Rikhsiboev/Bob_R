package com.bob_r.repository;

import com.bob_r.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {
}
