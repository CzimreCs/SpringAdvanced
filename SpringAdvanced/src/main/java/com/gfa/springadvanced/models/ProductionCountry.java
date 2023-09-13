package com.gfa.springadvanced.models;

import jakarta.persistence.*;

@Entity
@Table(name = "productioncountries")
public class ProductionCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productionCountry;

    @ManyToOne
    private Movie movieCountry;

    public ProductionCountry() {
    }

    public ProductionCountry(String productionCountry) {
        this.productionCountry = productionCountry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public void setProductionCountry(String productionCountry) {
        this.productionCountry = productionCountry;
    }

    public Movie getMovieCountry() {
        return movieCountry;
    }

    public void setMovieCountry(Movie movieCountry) {
        this.movieCountry = movieCountry;
    }
}
