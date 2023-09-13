package com.gfa.springadvanced.repositories;

import com.gfa.springadvanced.models.SpokenLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpokenLanguageRepository extends JpaRepository<SpokenLanguage, Long> {
}
