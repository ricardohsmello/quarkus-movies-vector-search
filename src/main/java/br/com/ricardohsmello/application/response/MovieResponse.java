package br.com.ricardohsmello.application.response;

import br.com.ricardohsmello.domain.entity.Movie;

import java.util.List;

public record MovieResponse(
        String id,
        String title,
        String plot,
        String fullPlot,
        int year,
        List<String> genres,
        List<String> cast,
        Object rating) {
    public static MovieResponse fromDomain(Movie movie) {
        return new MovieResponse(
                movie.id(),
                movie.title(),
                movie.plot(),
                movie.fullPlot(),
                movie.year(),
                movie.genres(),
                movie.cast(),
                movie.rating()
        );
    }
}
