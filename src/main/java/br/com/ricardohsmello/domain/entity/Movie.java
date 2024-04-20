package br.com.ricardohsmello.domain.entity;

import br.com.ricardohsmello.application.response.MovieResponse;

import java.util.Date;
import java.util.List;

 public record Movie(
    String plot,
    List<String> genres,
    List<String> cast,
    String poster,
    String title,
    String fullPlot,
    List<String> languages,
    Date released,
    List<String> directors,
    int year) {
     public MovieResponse toResponse() {
         return new MovieResponse(
                 title, plot, fullPlot, year, genres, cast
         );
     }
 }



