package com.gfa.springadvanced.services;

import com.gfa.springadvanced.models.dtos.MovieDTO;

public interface MovieService {
    void saveMovie(MovieDTO movieDTO);

    MovieDTO fetchLatestMovie();

}
