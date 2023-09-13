package com.gfa.springadvanced.models;

import jakarta.persistence.*;

@Entity
@Table(name = "productioncompanies")
public class ProductionCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productionCompany;

    @ManyToOne
    private Movie movieCompany;

    public ProductionCompany() {
    }

    public ProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }

    public Movie getMovieCompany() {
        return movieCompany;
    }

    public void setMovieCompany(Movie movieCompany) {
        this.movieCompany = movieCompany;
    }
}
