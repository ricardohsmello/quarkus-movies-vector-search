package br.com.ricardohsmello.application.response;

import java.util.List;

public record MovieResponse(
        String id,
        String title,
        String plot,
        String fullPlot,
        int year,
        List<String> genres,
        List<String> cast,
        double rating) {
}
