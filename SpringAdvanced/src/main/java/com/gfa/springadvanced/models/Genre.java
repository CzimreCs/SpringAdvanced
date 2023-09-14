package com.gfa.springadvanced.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String genre;

    @ManyToOne
    private Movie movieGenre;

    public Genre() {
    }

    public Genre(String genre) {
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Movie getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(Movie movieGenre) {
        this.movieGenre = movieGenre;
    }

    @Override
    public String toString() {
        return getGenre();
    }
}
