package com.gfa.springadvanced.repositories;

import com.gfa.springadvanced.models.ProductionCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionCountryRepository extends JpaRepository<ProductionCountry, Long> {
}
