package br.com.ricardohsmello.domain.entity;

import br.com.ricardohsmello.application.response.MovieResponse;

import java.util.Date;
import java.util.List;

 public record Movie(
    String id,
    String plot,
    List<String> genres,
    List<String> cast,
    String poster,
    String title,
    String fullPlot,
    List<String> languages,
    Date released,
    List<String> directors,
    int year,
    double rating
    ) {
     public MovieResponse toResponse() {
         return new MovieResponse(
                id, title, plot, fullPlot, year, genres, cast, rating
         );
     }
 }



