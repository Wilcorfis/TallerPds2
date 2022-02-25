package co.com.poli.servicemovie;

import co.com.poli.servicemovie.entities.Showtimes;
import co.com.poli.servicemovie.entities.Movie;
import co.com.poli.servicemovie.repository.MovieRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class MovieRepositoryMockTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void when_findByCategory_return_ListProducts(){
        Movie movie = Movie.builder()
                .title("Juguete")
                .director("wilmer")
                .rating(3)
                .showtimes(Showtimes.builder().id(3L).build())
                .build();
        movieRepository.save(movie);
        List<Movie> movies = movieRepository.findByShowtimes(movie.getShowtimes());
        Assertions.assertThat(movies.size()).isEqualTo(2);
    }

}
