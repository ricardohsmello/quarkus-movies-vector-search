package br.com.ricardohsmello.application.response;

import java.util.List;

public record EmbeddingResponse(
        List<DataItem> data
) {
    public record DataItem(
            List<Double> embedding
    ){}

}
