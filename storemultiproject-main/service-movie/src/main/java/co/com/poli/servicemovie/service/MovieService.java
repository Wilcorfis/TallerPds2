package co.com.poli.servicemovie.service;

import co.com.poli.servicemovie.entities.Movie;

import java.util.List;

public interface MovieService {

    void save(Movie movie);
    void delete(Movie product);
    List<Movie> findAll();
    Movie findById(Long id);

}
