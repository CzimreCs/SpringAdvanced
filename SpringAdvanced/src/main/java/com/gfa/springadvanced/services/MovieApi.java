package com.gfa.springadvanced.services;

import com.gfa.springadvanced.models.dtos.MovieByTitleDTO;
import com.gfa.springadvanced.models.dtos.MovieDTO;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;


@Service
public interface MovieApi {
    @GET("/3/movie/latest")
    Call<MovieDTO> fetchLatestMovie(@Query("api_key") String api_key);

    // --url 'https://api.themoviedb.org/3/search/movie?include_adult=false&language=en-US&page=1' \
    //https://api.themoviedb.org/3/search/movie?query=Alien&api_key=eaba4dbb76a3b2fed7844f2747b12507
    //https://api.themoviedb.org/3/search/?movie=Alien&api_key=eaba4dbb76a3b2fed7844f2747b12507
    @GET("/3/search/movie")
    Call<MovieByTitleDTO> fetchMovieByTitle(@Query("query") String movie,
                                            @Query("api_key") String api_key);
}
