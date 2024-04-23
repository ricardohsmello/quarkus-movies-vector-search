package br.com.ricardohsmello.application.config;

import br.com.ricardohsmello.domain.gateway.OpenAIGateway;
import br.com.ricardohsmello.domain.repository.MovieRepository;
import br.com.ricardohsmello.domain.service.MovieService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class ServiceConfig {

    @Produces
    MovieService produceMovieService(
            MovieRepository movieRepository,
            OpenAIGateway openAIGateway
    ) {
        return new MovieService(movieRepository, openAIGateway);
    }
}
