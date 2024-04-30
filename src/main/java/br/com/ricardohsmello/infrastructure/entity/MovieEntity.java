package br.com.ricardohsmello.infrastructure.entity;

import br.com.ricardohsmello.domain.entity.Movie;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.List;

@MongoEntity(collection="movies")
public class MovieEntity  {
    public ObjectId id;
    public String plot;
    public List<String> genres;
    public List<String> cast;
    public String poster;
    public String title;
    @BsonProperty("fullplot")
    public String fullPlot;
    public List<String> languages;
    public List<String> directors;
    public int year;
    public Imdb imdb;

    public Movie toDomain() {
        return new Movie(id.toString(), plot, genres, cast, poster, title, fullPlot, languages, directors, year, imdb.rating);
    }

    public static class Imdb {
        public double rating;
    }

}



