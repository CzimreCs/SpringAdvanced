package com.gfa.springadvanced.services;

import com.gfa.springadvanced.models.dtos.MovieDTO;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


@Service
public interface MovieApi {
    @GET("/3/movie/latest")
    Call<MovieDTO> fetchLatestMovie(@Query("api_key") String api_key);
}
