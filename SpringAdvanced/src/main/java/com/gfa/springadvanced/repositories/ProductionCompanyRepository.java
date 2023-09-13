package com.gfa.springadvanced.repositories;

import com.gfa.springadvanced.models.ProductionCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionCompanyRepository extends JpaRepository<ProductionCompany, Long> {
}
