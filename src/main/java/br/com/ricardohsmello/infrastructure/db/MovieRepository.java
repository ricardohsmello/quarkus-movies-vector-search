package br.com.ricardohsmello.infrastructure.db;

import br.com.ricardohsmello.domain.entity.Movie;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MovieRepository implements PanacheMongoRepository<Movie> {

    public Movie findByTitle(String title) {
        return find("title", title).firstResult();
    }

    public List<Movie> findSimilar(List<Double> embedding, Long limit) {

        List<Movie> results = new ArrayList<>();
        for (Movie movie : this.mongoCollection().aggregate(List.of(
                new Document(
                        "$vectorSearch",
                        new Document("queryVector", embedding)
                                .append("path", "plot_embedding")
                                .append("numCandidates", 3L)
                                .append("index", "vector_index")
                                .append("limit", limit)
                )
        ))) {
            results.add(movie);
        }

        return results;
    }

}