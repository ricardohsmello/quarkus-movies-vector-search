package br.com.ricardohsmello.domain.service.impl;

import br.com.ricardohsmello.domain.entity.Movie;
import br.com.ricardohsmello.domain.repository.MovieRepository;
import br.com.ricardohsmello.domain.service.MovieService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class MovieServiceImpl implements MovieService {

    @Inject
    MovieRepository movieRepository;

    @Override
    public List<Movie> getAll() {
        return movieRepository.getAll();
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
