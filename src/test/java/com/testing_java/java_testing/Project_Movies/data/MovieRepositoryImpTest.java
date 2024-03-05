package com.testing_java.java_testing.Project_Movies.data;

import com.testing_java.java_testing.Project_Movies.model.Genre;
import com.testing_java.java_testing.Project_Movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import static org.hamcrest.MatcherAssert.assertThat;


class MovieRepositoryImpTest {
    private MovieRepositoryImp movieRepositoryImp;
    private DataSource dataSource;

    // Se ejecuta antes de cada test
    @BeforeEach
    void setUp() throws SQLException {
        // Database in memory
        this.dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        // Execute script for create Table
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        // Template for repository
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        this.movieRepositoryImp = new MovieRepositoryImp(jdbcTemplate);
    }

    @Test
    void loadAllMovies() {
        // ARRANGE
        Collection<Movie> movies = movieRepositoryImp.findAll();

        // ACT & ASSERT (2 FORMAS DE COMPARAR)
         assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie("Dark Knight", 152, Genre.ACTION),
                new Movie("Memento", 113, Genre.THRILLER),
                new Movie("Matrix", 136, Genre.ACTION)
        )));

        Assertions.assertEquals(movies, Arrays.asList(
                new Movie("Dark Knight", 152, Genre.ACTION),
                new Movie("Memento", 113, Genre.THRILLER),
                new Movie("Matrix", 136, Genre.ACTION)
        ));
    }

    @Test
    void loadMovieById(){
        // ARRANGE
        Movie movie= movieRepositoryImp.findById(2);

        // ACT & ASSERT
        assertThat(movie, CoreMatchers.is(new Movie("Memento", 113, Genre.THRILLER)));
    }

    @Test
    void intertAMovie(){
        // ARRANGE
        Movie movie=new Movie("Super 8", 112, Genre.THRILLER);

        // ACT & ASSERT
        movieRepositoryImp.saveOrUpdate(movie);

        Movie movieFinded=movieRepositoryImp.findById(4);

        assertThat(movie, CoreMatchers.is(movieFinded));
    }

    // Se ejecuta despues de cada test
    @AfterEach
    void tearDown() throws Exception{
        // Remove H2 files -- https://stackoverflow.com/a/51809831/1121497
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files"); // "shutdown" is also enough for mem db
    }
}