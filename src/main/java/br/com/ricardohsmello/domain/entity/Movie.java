package br.com.ricardohsmello.domain.entity;

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
    List<String> directors,
    int year,
    Object rating
    ) {
 }



