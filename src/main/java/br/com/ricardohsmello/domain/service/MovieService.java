package br.com.ricardohsmello.domain.service;

import br.com.ricardohsmello.domain.entity.Movie;
import br.com.ricardohsmello.domain.gateway.OpenAIGateway;
import br.com.ricardohsmello.domain.repository.MovieRepository;

import java.util.List;

public class MovieService {

    private final MovieRepository movieRepository;
    private final OpenAIGateway openAIGateway;

    public MovieService(
            MovieRepository movieRepository ,
            OpenAIGateway openAIGateway) {
        this.movieRepository = movieRepository;
        this.openAIGateway = openAIGateway;
    }

    public List<Movie> findSimilar(String input) {
        List<Double> embedding = openAIGateway.getEmbedding(input);
        return movieRepository.findSimilar(embedding);
    }
}
