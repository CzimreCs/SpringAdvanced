package com.gfa.springadvanced.repositories;

import com.gfa.springadvanced.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findByMovieId(Long movieId);

    Boolean existsByMovieId(Long movieId);

    Optional<List<Movie>> findAllByTitle(String title);

}
