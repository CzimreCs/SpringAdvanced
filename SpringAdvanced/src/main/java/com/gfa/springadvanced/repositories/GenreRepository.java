package com.gfa.springadvanced.repositories;

import com.gfa.springadvanced.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    List<Genre> findAllByMovieGenreId(Long movieId);
}
