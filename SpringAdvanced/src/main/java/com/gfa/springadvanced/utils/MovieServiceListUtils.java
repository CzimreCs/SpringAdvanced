package com.gfa.springadvanced.utils;

import com.gfa.springadvanced.models.Genre;
import com.gfa.springadvanced.models.ProductionCompany;
import com.gfa.springadvanced.models.ProductionCountry;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieServiceListUtils {
    public MovieServiceListUtils() {}

    public List<ProductionCountry> countryMaker(List<String> list) {
        List<ProductionCountry> productionCountries = new ArrayList<>();
        if (list != null ) {
            for (String item : list) {
                productionCountries.add(new ProductionCountry(item));
            }
        }
        return productionCountries;
    }

    public List<ProductionCompany> companyMaker(List<String> list) {
        List<ProductionCompany> productionCompanies = new ArrayList<>();
        if (list != null ) {
            for (String item : list) {
                productionCompanies.add(new ProductionCompany(item));
            }
        }
        return productionCompanies;
    }


    public List<Genre> genreMaker(List<String> list) {
        List<Genre> genres = new ArrayList<>();
        if (list != null ) {
            for (String item : list) {
                genres.add(new Genre(item));
            }
        }
        return genres;
    }
}
