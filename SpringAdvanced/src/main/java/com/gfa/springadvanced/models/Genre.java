package com.gfa.springadvanced.models;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Movie movieGenre;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String genre) {
        this.name = genre;
    }

    public Movie getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(Movie movieGenre) {
        this.movieGenre = movieGenre;
    }
}

/*
 ****{
    "adult": false,
    "backdrop_path": null,
    "belongs_to_collection": null,
    "budget": 0,
    "genres": [],
    "homepage": "",
    "id": 1178978,
    "imdb_id": null,
    "original_language": "en",
    "original_title": "Freddie Starr: The Outrageous Freddie Starr",
    "overview": "FREDDIE STARR IS BACK...  and is an outrageous as ever. Fun, laughter and music are the name of the game in the specially compiled comedy extravaganza, as a host of celebrities are given the Freddie Starr touch.\r The outrageous Freddie Starr is aided and abetted by:  DES O'CONNOR, SHIRLEY BASSEY  GARY LINEKER, ANNA DAWSON  TIM BARRETT AND JANE WEST  also appearing are  THE COLIN KEYS ORCHESTRA and THE ALAN BRADEN ORCHESTRA",
    "popularity": 0.0,
    "poster_path": null,
    "production_companies": [],
    "production_countries": [],
    "release_date": "",
    "revenue": 0,
    "runtime": 52,
    "spoken_languages": [],
    "status": "Released",
    "tagline": "",
    "title": "Freddie Starr: The Outrageous Freddie Starr",
    "video": false,
    "vote_average": 0.0,
    "vote_count": 0
}
* {
    "adult": false,
    "backdropPath": null,
    "budget": 0,
    "belongsToCollection": null,
    "genres": [],
    "homepage": "",
    "movieId": null,
    "imdbId": null,
    "originalLanguage": "en",
    "originalTitle": "Freddie Starr: The Outrageous Freddie Starr",
    "overview": "",
    "popularity": 0.0,
    "posterPath": null,
    "productionCompanies": [],
    "productionCountries": [],
    "releaseDate": "",
    "revenue": 0,
    "runtime": 0,
    "spokenLanguages": [],
    "status": "Released",
    "tagline": "",
    "title": "Freddie Starr: The Outrageous Freddie Starr",
    "video": false,
    "voteAverage": 0.0,
    "voteCount": 0
}
*  */