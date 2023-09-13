package com.gfa.springadvanced.services;

import com.gfa.springadvanced.models.*;
import com.gfa.springadvanced.models.dtos.MovieDTO;
import com.gfa.springadvanced.repositories.*;
import com.gfa.springadvanced.utils.Converters;
import com.gfa.springadvanced.utils.MovieServiceListUtils;
import com.gfa.springadvanced.utils.RetrofitUtil;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final GenreRepository genreRepository;
    private final MovieRepository movieRepository;
    private final ProductionCompanyRepository productionCompanyRepository;
    private final ProductionCountryRepository productionCountryRepository;
    private final SpokenLanguageRepository spokenLanguageRepository;
    private final MovieServiceListUtils movieServiceListUtils;
    private Retrofit retrofit;
    private MovieApi movieApi;
    private Converters converters;


    public MovieServiceImpl(GenreRepository genreRepository, MovieRepository movieRepository, ProductionCompanyRepository productionCompanyRepository,
                            ProductionCountryRepository productionCountryRepository, SpokenLanguageRepository spokenLanguageRepository,
                            MovieServiceListUtils movieServiceListUtils, Converters converters) {
        this.genreRepository = genreRepository;
        this.movieRepository = movieRepository;
        this.productionCompanyRepository = productionCompanyRepository;
        this.productionCountryRepository = productionCountryRepository;
        this.spokenLanguageRepository = spokenLanguageRepository;
        this.movieServiceListUtils = movieServiceListUtils;
        this.retrofit = RetrofitUtil.getRetrofitInstance();
        this.movieApi = retrofit.create(MovieApi.class);
        this.converters = converters;
    }

    @Override
    public void saveMovie(MovieDTO movieDTO) {
        Movie movie = converters.convertToMovieEntity(movieDTO);
        movieRepository.save(movie);
        List<Genre> genres = movieServiceListUtils.genreMaker(movieDTO.getGenres());
        setGenresToMovie(movie, genres);
        List<ProductionCompany> productionCompanies = movieServiceListUtils.companyMaker(movieDTO.getProductionCompanies());
        setProductionCompaniesToMovie(movie, productionCompanies);
        List<ProductionCountry> productionCountries = movieServiceListUtils.countryMaker(movieDTO.getProductionCountries());
        setProductionCountriesToMovie(movie, productionCountries);
        List<SpokenLanguage> spokenLanguages = movieDTO.getSpokenLanguages();
        setSpokenLanguageToMovie(movie, spokenLanguages);
        movieRepository.save(movie);
    }

    @Override
    public MovieDTO fetchLatestMovie() {
        MovieDTO latestMovie = new MovieDTO();
        Call<MovieDTO> latestMovieCall = movieApi.fetchLatestMovie("eaba4dbb76a3b2fed7844f2747b12507");
        try {
            Response<MovieDTO> response = latestMovieCall.execute();
            try {
                if (response.isSuccessful()) {
                    latestMovie = response.body();
                }
            } catch (NullPointerException ex) {
                throw new NullPointerException();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        saveMovie(latestMovie);
        return latestMovie;

    }

    private void setSpokenLanguageToMovie(Movie movie, List<SpokenLanguage> spokenLanguages) {
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


    private void setProductionCountriesToMovie(Movie movie, List<ProductionCountry> productionCountries) {
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

    private void setProductionCompaniesToMovie(Movie movie, List<ProductionCompany> productionCompanies) {
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

    private void setGenresToMovie(Movie movie, List<Genre> genres) {
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
