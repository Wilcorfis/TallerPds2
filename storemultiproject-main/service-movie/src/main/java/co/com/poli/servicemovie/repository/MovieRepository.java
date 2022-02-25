package co.com.poli.servicemovie.repository;

import co.com.poli.servicemovie.entities.Movie;
import co.com.poli.servicemovie.entities.Showtimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    List<Movie> findByShowtimes(Showtimes showtimes);
}
