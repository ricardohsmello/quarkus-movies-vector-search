package br.com.ricardohsmello;

import jakarta.inject.Inject;
import jakarta.nosql.document.DocumentTemplate;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/movies")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class MoviesResource {

    @Inject
    DocumentTemplate template;

    @GET
    public List<Movies> listAll(@QueryParam("title") String title) {

        if (title == null) {
            return template.select(Movies.class).limit(5).result();
        }

        return template.select(Movies.class)
                .where("title")
                .like(title)
                .result();
    }
}


