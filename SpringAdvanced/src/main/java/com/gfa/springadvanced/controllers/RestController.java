package com.gfa.springadvanced.controllers;

import com.gfa.springadvanced.models.dtos.MovieDTO;
import com.gfa.springadvanced.services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final MovieService movieService;

    public RestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @RequestMapping("/api/movie/")
    public ResponseEntity<?> getLatestMovie(){

        return ResponseEntity.ok(movieService.fetchLatestMovie());
    }


/*
    @GetMapping("http://api.themoviedb.org/3/movie/latest?api_key=eaba4dbb76a3b2fed7844f2747b12507")
*/
}