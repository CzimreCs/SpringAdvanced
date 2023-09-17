package com.gfa.springadvanced.services;

import com.gfa.springadvanced.constants.RetrofitConstant;
import com.gfa.springadvanced.models.*;
import com.gfa.springadvanced.models.dtos.MovieByTitleDTO;
import com.gfa.springadvanced.models.dtos.MovieDTO;
import com.gfa.springadvanced.models.dtos.MovieForUserDTO;
import com.gfa.springadvanced.models.dtos.ResultDTO;
import com.gfa.springadvanced.repositories.*;
import com.gfa.springadvanced.utils.Converters;
import com.gfa.springadvanced.utils.MovieBuilder;
import com.gfa.springadvanced.utils.MovieServiceListUtils;
import com.gfa.springadvanced.utils.RetrofitUtil;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private final GenreRepository genreRepository;
    private final MovieRepository movieRepository;
    private final ProductionCompanyRepository productionCompanyRepository;
    private final ProductionCountryRepository productionCountryRepository;
    private final SpokenLanguageRepository spokenLanguageRepository;
    private final MovieServiceListUtils movieServiceListUtils;
    private final Retrofit retrofit;
    private final MovieApi movieApi;
    private final Converters converters;
    private final MovieBuilder movieBuilder;

    public MovieServiceImpl(GenreRepository genreRepository, MovieRepository movieRepository, ProductionCompanyRepository productionCompanyRepository,
                            ProductionCountryRepository productionCountryRepository, SpokenLanguageRepository spokenLanguageRepository,
                            MovieServiceListUtils movieServiceListUtils, Converters converters, MovieBuilder movieBuilder) {
        this.genreRepository = genreRepository;
        this.movieRepository = movieRepository;
        this.productionCompanyRepository = productionCompanyRepository;
        this.productionCountryRepository = productionCountryRepository;
        this.spokenLanguageRepository = spokenLanguageRepository;
        this.movieServiceListUtils = movieServiceListUtils;
        this.retrofit = RetrofitUtil.getRetrofitInstance();
        this.movieApi = retrofit.create(MovieApi.class);
        this.converters = converters;
        this.movieBuilder = movieBuilder;
    }

    @Override
    public void saveMovie(MovieDTO movieDTO) {
        Movie movie = converters.convertToMovieEntity(movieDTO);
        movieRepository.save(movie);
        List<Genre> genres = movieServiceListUtils.genreMaker(movieDTO.getGenres());
        movieBuilder.setGenresToMovie(movie, genres);
        List<ProductionCompany> productionCompanies = movieServiceListUtils.companyMaker(movieDTO.getProductionCompanies());
        movieBuilder.setProductionCompaniesToMovie(movie, productionCompanies);
        List<ProductionCountry> productionCountries = movieServiceListUtils.countryMaker(movieDTO.getProductionCountries());
        movieBuilder.setProductionCountriesToMovie(movie, productionCountries);
        List<SpokenLanguage> spokenLanguages = movieDTO.getSpokenLanguages();
        movieBuilder.setSpokenLanguageToMovie(movie, spokenLanguages);
        movieRepository.save(movie);
    }

    @Override
    public MovieDTO fetchLatestMovie() {
        MovieDTO latestMovie = new MovieDTO();
        Call<MovieDTO> latestMovieCall = movieApi.fetchLatestMovie(RetrofitConstant.API_KEY);
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
        Boolean isMovieInDB;
        isMovieInDB = movieRepository.existsByMovieId(latestMovie.getMovieId());

        if (!isMovieInDB) {
            saveMovie(latestMovie);
        }
        return latestMovie;
    }

    @Override
    public List<MovieForUserDTO> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieForUserDTO> moviesForUserDTO = converters.convertMoviesToMoviesForUserDTO(movies);

        return moviesForUserDTO;
    }

    @Override
    public List<MovieForUserDTO> getMoviesByTitle(String title) {
        Optional<List<Movie>> movies = movieRepository.findAllByTitle(title);
        MovieByTitleDTO movieList = new MovieByTitleDTO();
        if (movies.isPresent() && !movies.get().isEmpty()) {
            return converters.convertMoviesToMoviesForUserDTO(movies.get());
        }
        Call<MovieByTitleDTO> moviesToSave = movieApi.fetchMovieByTitle(title, RetrofitConstant.API_KEY);
        try {
            Response<MovieByTitleDTO> response = moviesToSave.execute();
            try {
                if (response.isSuccessful()) {
                    movieList = response.body();
                }
            } catch (NullPointerException ex) {
                throw new NullPointerException();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            for (ResultDTO movieTemp : movieList.getResults()) {
                saveMovie(converters.convertResultDTOToMovieDTO(movieTemp));
            }
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }

        return converters.convertMovieDTOListToMovieForUserDTOList(converters.convertResultListToMovieList(movieList.getResults()), MovieForUserDTO.class);
    }
}
