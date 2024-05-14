package br.com.ricardohsmello.infrastructure.response;

import java.util.List;

public record OpenAIResponse(
        List<DataItem> data
) {
    public record DataItem(
            List<Double> embedding
    ){}
}