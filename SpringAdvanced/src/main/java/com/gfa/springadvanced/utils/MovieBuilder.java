package com.gfa.springadvanced.utils;

import com.gfa.springadvanced.models.*;
import com.gfa.springadvanced.repositories.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieBuilder {
    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final ProductionCountryRepository productionCountryRepository;
    private final ProductionCompanyRepository productionCompanyRepository;
    private final SpokenLanguageRepository spokenLanguageRepository;


    public MovieBuilder(MovieRepository movieRepository, GenreRepository genreRepository, ProductionCountryRepository productionCountryRepository, ProductionCompanyRepository productionCompanyRepository, SpokenLanguageRepository spokenLanguageRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
        this.productionCountryRepository = productionCountryRepository;
        this.productionCompanyRepository = productionCompanyRepository;
        this.spokenLanguageRepository = spokenLanguageRepository;
    }

    public void setSpokenLanguageToMovie(Movie movie, List<SpokenLanguage> spokenLanguages) {
        if (spokenLanguages != null) {
            if (!spokenLanguages.isEmpty()) {
                for (SpokenLanguage tmp : spokenLanguages) {
                    tmp.setMovieLanguage(movie);
                    movieRepository.save(movie);
                    spokenLanguageRepository.save(tmp);
                }
            }
        }
    }

    public void setProductionCountriesToMovie(Movie movie, List<ProductionCountry> productionCountries) {
        if (productionCountries != null) {
            if (!productionCountries.isEmpty()) {
                for (ProductionCountry productionCountry : productionCountries) {
                    productionCountry.setMovieCountry(movie);
                    movieRepository.save(movie);
                    productionCountryRepository.save(productionCountry);
                }
            }
        }
    }

    public void setProductionCompaniesToMovie(Movie movie, List<ProductionCompany> productionCompanies) {
        if (productionCompanies != null) {
            if (!productionCompanies.isEmpty()) {
                for (ProductionCompany productionCompany : productionCompanies) {
                    productionCompany.setMovieCompany(movie);
                    movieRepository.save(movie);
                    productionCompanyRepository.save(productionCompany);
                }
            }
        }
    }

    public void setGenresToMovie(Movie movie, List<Genre> genres) {
        if (genres != null) {
            if (!genres.isEmpty()) {
                for (Genre genre : genres) {
                    genre.setMovieGenre(movie);
                    movieRepository.save(movie);
                    genreRepository.save(genre);
                }
            }
        }
    }
}
