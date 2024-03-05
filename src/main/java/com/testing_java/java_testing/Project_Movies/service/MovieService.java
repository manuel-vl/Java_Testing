package com.testing_java.java_testing.Project_Movies.service;

import com.testing_java.java_testing.Project_Movies.data.IMovieRepository;
import com.testing_java.java_testing.Project_Movies.model.Genre;
import com.testing_java.java_testing.Project_Movies.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService{
    private IMovieRepository movieRepository;

    public MovieService(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre){
        return movieRepository.findAll().stream().filter(movie -> movie.getGenre()==genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(int length){
        return movieRepository.findAll().stream().filter(movie -> movie.getMinutes()<=length).collect(Collectors.toList());
    }
}
