package co.com.poli.servicemovie;

import co.com.poli.servicemovie.entities.Showtimes;
import co.com.poli.servicemovie.entities.Movie;
import co.com.poli.servicemovie.repository.MovieRepository;
import co.com.poli.servicemovie.service.MovieService;
import co.com.poli.servicemovie.service.MovieServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class MovieServiceMockTest {

    @Mock
    private MovieRepository movieRepository;
    private MovieService movieService;

    @BeforeEach
    public void begin(){
        MockitoAnnotations.openMocks(this);
        movieService = new MovieServiceImpl(movieRepository);
        Movie movie = Movie.builder()
                .id(4L)
                .title("Test1")
                .director("dj cote")
                .rating(3)
                .showtimes(Showtimes.builder().id(3L).build())
                .build();
        Mockito.when(movieRepository.findById(4L))
                .thenReturn(Optional.of(movie));
    }

    @Test
    public void when_findById_return_Product(){
        Movie movie = movieService.findById(4L);
        Assertions.assertThat(movie.getTitle()).isEqualTo("Test1");
    }


}
