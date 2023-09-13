package com.gfa.springadvanced.services;

import com.gfa.springadvanced.models.Movie;
import com.gfa.springadvanced.models.dtos.MovieDTO;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Optional;

@Service
public interface MovieApi {
    @GET("/3/movie/latest")
    Call<MovieDTO> fetchLatestMovie(@Query("api_key") String api_key);

    //@GetMapping("http://api.themoviedb.org/3/movie/latest?api_key=eaba4dbb76a3b2fed7844f2747b12507")
    //Call<List<Repo>> repos = service.listRepos("octocat");
}
