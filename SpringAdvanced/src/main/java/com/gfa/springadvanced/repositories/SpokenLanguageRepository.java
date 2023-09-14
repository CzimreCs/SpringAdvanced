package com.gfa.springadvanced.repositories;

import com.gfa.springadvanced.models.Genre;
import com.gfa.springadvanced.models.SpokenLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpokenLanguageRepository extends JpaRepository<SpokenLanguage, Long> {
    List<SpokenLanguage> findAllByMovieLanguageId(Long movieId);
}
