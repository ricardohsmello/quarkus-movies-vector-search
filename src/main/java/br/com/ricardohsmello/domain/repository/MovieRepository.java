package br.com.ricardohsmello.domain.repository;

import br.com.ricardohsmello.domain.entity.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> getAll();
    Movie findByTitle(String title);
    List<Movie> findSimilar(List<Double> embedding, Long limit);
     Long getTotalNumberOfMovies();
}
