package br.com.ricardohsmello.infrastructure.entity;

import br.com.ricardohsmello.application.response.MovieResponse;
import br.com.ricardohsmello.domain.entity.Movie;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

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
    public Imdb imdb
//    @BsonProperty("imdb.rating")/
    ;

    public Movie toDomain() {
        return new Movie(id.toString(), plot, genres, cast, poster, title, fullPlot, languages, released, directors, year, imdb.rating);
    }

    public static class Imdb {
        public double rating;

    }
}



