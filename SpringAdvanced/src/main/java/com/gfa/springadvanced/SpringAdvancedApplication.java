package com.gfa.springadvanced;

import com.gfa.springadvanced.models.SpokenLanguage;
import com.gfa.springadvanced.models.dtos.MovieDTO;
import com.gfa.springadvanced.services.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringAdvancedApplication implements CommandLineRunner {


    private final MovieService movieService;

    public SpringAdvancedApplication(MovieService movieService) {
        this.movieService = movieService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringAdvancedApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
/*        List<String> genres = Arrays.asList("action", "comedy");
        List<String> companies = Arrays.asList("Warner", "Pixar");
        List<String> countries = Arrays.asList("USA", "UK");
        List<SpokenLanguage> languages = Arrays.asList(new SpokenLanguage("german", "345", "name"),
                new SpokenLanguage("english", "123iso", "eng"));
        LocalDate dtm = LocalDate.now();
        MovieDTO movieDTO = new MovieDTO(true, "backPath", 100, false, genres, "homepage", 200L, "imdbId", "originalLanguage",
                "originalTitle", "overview", 3.45, "postPath", companies, countries, dtm, 1, 90, languages, "status", "tagline",
                "title", true, 3.3, 12);
        movieService.saveMovie(movieDTO);*/
    }
}
