package br.com.ricardohsmello.domain.repository;

import br.com.ricardohsmello.domain.entity.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> findSimilar(List<Double> embedding);
}
