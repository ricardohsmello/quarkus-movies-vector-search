package br.com.ricardohsmello.application;

import br.com.ricardohsmello.application.request.MovieRequest;
import br.com.ricardohsmello.application.response.MovieResponse;
import br.com.ricardohsmello.domain.entity.Movie;
import br.com.ricardohsmello.domain.service.MovieService;
import br.com.ricardohsmello.domain.service.OpenAIService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Collections;
import java.util.List;

@Path("/movies")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class MoviesResource {

    @Inject
    MovieService movieService;

    @Inject
    OpenAIService openAIService;

    @GET
    public List<Movie> get(@QueryParam("title") String title) {
        if (title == null) {
            return movieService.getAll();
        }

        return Collections.singletonList(movieService.findByTitle(title));
    }

    @Path("/findSimilar")
    @POST
    public List<MovieResponse> process(MovieRequest request) {
        var embedding = openAIService.getEmbedding(request);
        return movieService.findSimilar(embedding, request.limit()).stream().map(Movie::toResponse).toList();
    }
}


