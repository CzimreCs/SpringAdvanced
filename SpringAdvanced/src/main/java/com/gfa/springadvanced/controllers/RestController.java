package com.gfa.springadvanced.controllers;

import com.gfa.springadvanced.models.dtos.MovieDTO;
import com.gfa.springadvanced.models.dtos.MovieForUserDTO;
import com.gfa.springadvanced.services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import retrofit2.http.Path;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/movie")
public class RestController {
    private final MovieService movieService;

    public RestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("latest")
    public ResponseEntity<?> getLatestMovie() {
        return ResponseEntity.ok(movieService.fetchLatestMovie());
    }

    @GetMapping("listAll")
    public ResponseEntity<List<MovieForUserDTO>> listAllMovies() {
        return ResponseEntity.ok().body(movieService.getAllMovies());
    }

    @GetMapping("/{title}")
    public ResponseEntity<List<MovieForUserDTO>> getMoviesByTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(movieService.getMoviesByTitle(title));
    }

}
