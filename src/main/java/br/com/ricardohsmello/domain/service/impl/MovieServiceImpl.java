package br.com.ricardohsmello.domain.service.impl;

import br.com.ricardohsmello.domain.entity.Movie;
import br.com.ricardohsmello.domain.service.MovieService;
import br.com.ricardohsmello.infrastructure.db.MovieRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class MovieServiceImpl implements MovieService {

    @Inject
    MovieRepository movieRepository;

    @Override
    public List<Movie> listAll() {
        return movieRepository.listAll();
    }

    @Override
    public Movie findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    @Override
    public List<Movie> findSimilar(List<Double> embedding, Long limit) {
        return movieRepository.findSimilar(embedding, limit);
    }
}
