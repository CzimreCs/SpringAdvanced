package com.gfa.springadvanced.services;

import com.gfa.springadvanced.models.dtos.MovieDTO;
import com.gfa.springadvanced.models.dtos.MovieForUserDTO;

import java.util.List;

public interface MovieService {
    void saveMovie(MovieDTO movieDTO);

    MovieDTO fetchLatestMovie();

    List<MovieForUserDTO> getAllMovies();

    List<MovieForUserDTO> getMoviesByTitle(String title);
}
