package com.gfa.springadvanced.utils;

import com.gfa.springadvanced.models.*;
import com.gfa.springadvanced.models.dtos.MovieDTO;
import com.gfa.springadvanced.models.dtos.MovieForUserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class Converters {

    private final MovieServiceListUtils movieServiceListUtils;
    private final ModelMapper modelMapper;

    public Converters(MovieServiceListUtils movieServiceListUtils, ModelMapper modelMapper) {
        this.movieServiceListUtils = movieServiceListUtils;
        this.modelMapper = modelMapper;
    }

    public Movie convertToMovieEntity(MovieDTO movieDTO) {
        return modelMapper.map(movieDTO, Movie.class);
    }

    public List<MovieForUserDTO> convertMoviesToMoviesForUserDTO(List<Movie> movies) {
        List<MovieForUserDTO> userMovies = new ArrayList<>();

        for (Movie movie : movies) {
            MovieForUserDTO userMovie = modelMapper.map(movie, MovieForUserDTO.class);

            userMovie.setGenres(movie.getMovieGenre().stream().map(Genre::getGenre).toList());

            userMovie.setProductionCompanies(movie.getProductionCompanies().stream()
                    .map(ProductionCompany::getProductionCompany).toList());

            userMovie.setProductionCompanies(movie.getProductionCountries().stream()
                    .map(ProductionCountry::getProductionCountry).toList());

            userMovie.setSpokenLanguages(movie.getSpokenLanguages());
            userMovies.add(userMovie);
        }
        return userMovies;
    }
}
