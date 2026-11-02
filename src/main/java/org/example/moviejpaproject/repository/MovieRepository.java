package org.example.moviejpaproject.repository;

import org.example.moviejpaproject.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long>{
}