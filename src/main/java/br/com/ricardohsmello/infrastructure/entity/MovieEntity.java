package br.com.ricardohsmello.infrastructure.entity;

import br.com.ricardohsmello.application.response.MovieResponse;
import br.com.ricardohsmello.domain.entity.Movie;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Date;
import java.util.List;

@MongoEntity(collection="embedded_movies")
public class MovieEntity extends PanacheMongoEntity {
    public String plot;
    public List<String> genres;
    public List<String> cast;
    public String poster;
    public String title;
    @BsonProperty("fullplot")
    public String fullPlot;
    public List<String> languages;
    public Date released;
    public List<String> directors;
    public int year;

    public Movie toDomain() {
        return new Movie(plot, genres, cast, poster, title, fullPlot, languages, released, directors, year);
    }
}

