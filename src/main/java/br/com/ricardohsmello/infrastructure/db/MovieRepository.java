package br.com.ricardohsmello.infrastructure.db;

import br.com.ricardohsmello.domain.entity.Movie;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MovieRepository implements PanacheMongoRepository<Movie> {

    public Movie findByTitle(String title) {
        return find("title", title).firstResult();
    }

    public List<Movie> findSimilar(List<Double> embedding, Long limit) {

        List<Bson> list = List.of(
                new Document(
                        "$vectorSearch",
                        new Document("queryVector", embedding)
                                .append("path", "plot_embedding")
                                .append("numCandidates", 3L)
                                .append("index", "vector_index")
                                .append("limit", limit)
                )
        );

        List<Movie> results = new ArrayList<>();

        for (Movie movie : this.mongoCollection().aggregate(list)) {
            results.add(movie);
        }

        return results;
    }

}