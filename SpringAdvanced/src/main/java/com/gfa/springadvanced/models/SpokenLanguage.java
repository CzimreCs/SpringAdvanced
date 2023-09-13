package com.gfa.springadvanced.models;

import jakarta.persistence.*;

@Entity
@Table(name = "spokenlanguages")
public class SpokenLanguage {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String englishName;
    @Column
    private String iso6391;
    private String name;
    @ManyToOne
    private Movie movieLanguage;

    public SpokenLanguage() {
    }

    public SpokenLanguage(String englishName, String iso6391, String name) {
        this.englishName = englishName;
        this.iso6391 = iso6391;
        this.name = name;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getIso6391() {
        return iso6391;
    }

    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Movie getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(Movie movieLanguage) {
        this.movieLanguage = movieLanguage;
    }
}
