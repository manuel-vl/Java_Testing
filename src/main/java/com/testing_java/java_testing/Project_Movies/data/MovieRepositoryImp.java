package com.testing_java.java_testing.Project_Movies.data;

import com.testing_java.java_testing.Project_Movies.model.Genre;
import com.testing_java.java_testing.Project_Movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;

public class MovieRepositoryImp implements  IMovieRepository{
    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] args={id};

        return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE id = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("INSERT INTO movies (name, minutes, genre) values  (?,?,?)", movie.getName(), movie.getMinutes(), movie.getGenre().toString());
    }

    // Creando pelicula a partir de la DB
    private static RowMapper<Movie> movieMapper= (resultSet, rowNum) -> new Movie(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getInt("minutes"),
            Genre.valueOf(resultSet.getString("genre"))
    );
}
