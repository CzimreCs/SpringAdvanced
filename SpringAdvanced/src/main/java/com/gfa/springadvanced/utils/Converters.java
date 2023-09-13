package com.gfa.springadvanced.utils;

import com.gfa.springadvanced.models.*;
import com.gfa.springadvanced.models.dtos.MovieDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Converters {

    @Autowired
    private ModelMapper modelMapper;
    private MovieDTO convertToDto(Movie movie, Genre genre, ProductionCompany productionCompany, ProductionCountry productionCountry, SpokenLanguage spokenLanguage) {
        return modelMapper.map(movie, MovieDTO.class);
    }

    public Movie convertToMovieEntity(MovieDTO movieDTO) {
        /*
        TypeMap<MovieDTO, Movie> propertyMapper = modelMapper.createTypeMap(MovieDTO.class, Movie.class);
        propertyMapper.addMappings(mapper -> mapper.skip(Movie::setId));
        modelMapper.map(movieDTO.getMovieId(), Movie.class).setMovieId(movieDTO.getMovieId());
        modelMapper.map(movieDTO.getImdbId(), Movie.class).setImdbId(movieDTO.getImdbId());*/
        return modelMapper.map(movieDTO, Movie.class);

    }

    private Genre convertToGenreEntity(MovieDTO movieDTO) {
        return modelMapper.map(movieDTO, Genre.class);
    }

    private ProductionCompany convertToCompanyEntity(MovieDTO movieDTO) {
        return modelMapper.map(movieDTO, ProductionCompany.class);
    }

    private ProductionCountry convertToCountryEntity(MovieDTO movieDTO) {
        return modelMapper.map(movieDTO, ProductionCountry.class);
    }

    private SpokenLanguage convertToLanguageEntity(MovieDTO movieDTO) {
        return modelMapper.map(movieDTO, SpokenLanguage.class);
    }
}
