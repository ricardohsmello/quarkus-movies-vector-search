package br.com.ricardohsmello.application.response;

import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;

public record MovieResponse(
        String title,
        String plot,
        @BsonProperty("fullplot")
        String fullPlot,
        int year,
        List<String> genres,
        List<String> cast
) {
}
