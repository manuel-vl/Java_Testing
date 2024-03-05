package com.testing_java.java_testing.Project_Movies.data;

import com.testing_java.java_testing.Project_Movies.model.Movie;

import java.util.Collection;

public interface IMovieRepository {
    Movie findById(long id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
}
