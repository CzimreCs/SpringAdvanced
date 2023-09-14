package com.gfa.springadvanced.repositories;

import com.gfa.springadvanced.models.ProductionCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductionCompanyRepository extends JpaRepository<ProductionCompany, Long> {
    List<ProductionCompany> findAllByMovieCompanyId (Long movieId);
}
