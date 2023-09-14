package com.gfa.springadvanced.utils;

import com.gfa.springadvanced.models.Genre;
import com.gfa.springadvanced.models.ProductionCompany;
import com.gfa.springadvanced.models.ProductionCountry;
import com.gfa.springadvanced.models.SpokenLanguage;
import com.gfa.springadvanced.repositories.GenreRepository;
import com.gfa.springadvanced.repositories.ProductionCompanyRepository;
import com.gfa.springadvanced.repositories.ProductionCountryRepository;
import com.gfa.springadvanced.repositories.SpokenLanguageRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieServiceListUtils {

    private final GenreRepository genreRepository;
    private final SpokenLanguageRepository spokenLanguageRepository;
    private final ProductionCompanyRepository productionCompanyRepository;
    private final ProductionCountryRepository productionCountryRepository;

    public MovieServiceListUtils(GenreRepository genreRepository, SpokenLanguageRepository spokenLanguageRepository, ProductionCompanyRepository productionCompanyRepository, ProductionCountryRepository productionCountryRepository) {
        this.genreRepository = genreRepository;
        this.spokenLanguageRepository = spokenLanguageRepository;
        this.productionCompanyRepository = productionCompanyRepository;
        this.productionCountryRepository = productionCountryRepository;
    }

    public List<ProductionCountry> countryMaker(List<String> list) {
        List<ProductionCountry> productionCountries = new ArrayList<>();
        if (list != null) {
            for (String item : list) {
                productionCountries.add(new ProductionCountry(item));
            }
        }
        return productionCountries;
    }

    public List<ProductionCompany> companyMaker(List<String> list) {
        List<ProductionCompany> productionCompanies = new ArrayList<>();
        if (list != null) {
            for (String item : list) {
                productionCompanies.add(new ProductionCompany(item));
            }
        }
        return productionCompanies;
    }

    public List<Genre> genreMaker(List<String> list) {
        List<Genre> genres = new ArrayList<>();
        if (list != null) {
            for (String item : list) {
                genres.add(new Genre(item));
            }
        }
        return genres;
    }

    List<Genre> getGenresByMovieId (Long id){
        return genreRepository.findAllByMovieGenreId(id);
    }

    List<ProductionCompany> getProductionCompaniesByMovieId (Long id) {
        return productionCompanyRepository.findAllByMovieCompanyId(id);
    }

    List<ProductionCountry> getProductionCountriesByMovieId (Long id) {
        return productionCountryRepository.findAllByMovieCountryId(id);
    }

    List<SpokenLanguage> getSpokenLanguagesByMovieId(Long id){
        return spokenLanguageRepository.findAllByMovieLanguageId(id);
    }


}
