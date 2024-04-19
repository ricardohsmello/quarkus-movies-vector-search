package br.com.ricardohsmello.application.response;

import java.util.List;

public class EmbeddingResponse {
    private List<DataItem> data;

    public List<DataItem> getData() {
        return data;
    }

    public static class DataItem {
        private List<Double> embedding;

        public List<Double> getEmbedding() {
            return embedding;
        }
    }
}