package com.gfa.springadvanced.utils;

import com.gfa.springadvanced.models.*;
import com.gfa.springadvanced.models.dtos.MovieDTO;
import com.gfa.springadvanced.models.dtos.MovieForUserDTO;
import com.gfa.springadvanced.models.dtos.ResultDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<MovieForUserDTO>
                convertMovieDTOListToMovieForUserDTOList(List<MovieDTO> list, Class<MovieForUserDTO> movieForUserDTO) {
        return list.stream().map(element-> modelMapper.map(element, movieForUserDTO)).toList();
    }

    public List<MovieForUserDTO> convertMoviesToMoviesForUserDTO(List<Movie> movies) {
        List<MovieForUserDTO> userMovies = new ArrayList<>();

        for (Movie movie : movies) {
            MovieForUserDTO userMovie = modelMapper.map(movie, MovieForUserDTO.class);

            userMovie.setGenres(movie.getMovieGenre().stream().map(Genre::getName).toList());

            userMovie.setProductionCompanies(movie.getProductionCompanies().stream()
                    .map(ProductionCompany::getProductionCompany).toList());

            userMovie.setProductionCountries(movie.getProductionCountries().stream()
                    .map(ProductionCountry::getProductionCountry).toList());

            userMovie.setSpokenLanguages(movie.getSpokenLanguages());
            userMovies.add(userMovie);
        }
        return userMovies;
    }

    public MovieDTO convertResultDTOToMovieDTO(ResultDTO resultDTO){
        return modelMapper.map(resultDTO, MovieDTO.class);
    }

    public List<MovieDTO> convertResultListToMovieList(List<ResultDTO> resultDTOs) {
        List<MovieDTO> movies = new ArrayList<>();
        for (ResultDTO result : resultDTOs) {
            movies.add(convertResultDTOToMovieDTO(result));
        }
        return movies;
    }


}
