package br.com.ricardohsmello.domain.service;

import br.com.ricardohsmello.domain.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> listAll();
    Movie findByTitle(String title);
    List<Movie> findSimilar(List<Double> embedding, Long limit);
}
