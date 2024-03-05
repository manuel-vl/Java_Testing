package com.testing_java.java_testing.Project_Movies.service;

import com.testing_java.java_testing.Project_Movies.data.IMovieRepository;
import com.testing_java.java_testing.Project_Movies.model.Genre;
import com.testing_java.java_testing.Project_Movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

class MovieServiceTest {
    private MovieService movieService;

    @BeforeEach
    public void setUp() throws Exception{
        // Service implemente repositorio, por ende debemos mockear.
        IMovieRepository movieRepository= Mockito.mock(IMovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION),
                        new Movie(2, "Memento", 113, Genre.THRILLER),
                        new Movie(3, "There's Something About Marty", 119, Genre.COMEDY),
                        new Movie(4, "Super 8", 112, Genre.THRILLER),
                        new Movie(5, "Scream", 111, Genre.HORROR),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY),
                        new Movie(7, "Matrix", 136, Genre.ACTION)
                )
        );

        this.movieService=new MovieService(movieRepository);
    }

    @Test
    void returnMoviesByGenre(){
        // ARRANGE

        // ACT
        Collection<Movie> movies= this.movieService.findMoviesByGenre(Genre.COMEDY);

        List<Integer> moviesId = getMoviesId(movies);

        // ASSERT
        assertThat(moviesId, CoreMatchers.is(Arrays.asList(3, 6)));
    }

    @Test
    void returnMoviesByDuration(){
        // ARRANGE

        // ACT
        Collection<Movie> movies=this.movieService.findMoviesByLength(119);

        List<Integer> moviesId = getMoviesId(movies);

        // ASSERT
        assertThat(moviesId, CoreMatchers.is(Arrays.asList(2, 3,4,5,6)));
    }

    private static List<Integer> getMoviesId(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}