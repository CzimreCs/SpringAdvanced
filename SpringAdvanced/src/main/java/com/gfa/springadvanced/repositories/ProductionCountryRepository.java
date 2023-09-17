package com.gfa.springadvanced.repositories;

import com.gfa.springadvanced.models.ProductionCompany;
import com.gfa.springadvanced.models.ProductionCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductionCountryRepository extends JpaRepository<ProductionCountry, Long> {
    List<ProductionCountry> findAllByMovieCountryId(Long movieId);
}
