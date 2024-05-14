package br.com.ricardohsmello.infrastructure.repository;

import br.com.ricardohsmello.domain.entity.Movie;
import br.com.ricardohsmello.domain.repository.MovieRepository;
import br.com.ricardohsmello.infrastructure.entity.MovieEntity;
import com.mongodb.client.AggregateIterable;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MovieRepositoryImpl implements PanacheMongoRepository<MovieEntity>, MovieRepository {

    @Override
    public List<Movie> findSimilar(List<Double> embedding) {
        List<Movie> movieList = new ArrayList<>();

        try {
            AggregateIterable<MovieEntity> aggregate = mongoCollection().aggregate(List.of(
                    new Document(
                            "$vectorSearch",
                            new Document("queryVector", embedding)
                                    .append("path", "movie_embedded")
                                    .append("numCandidates", 20)
                                    .append("index", "vector_index")
                                    .append("limit", 10)
                    )
            ));

            for (MovieEntity movieEntity : aggregate) {
                movieList.add(movieEntity.toDomain());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return movieList;
    }
}