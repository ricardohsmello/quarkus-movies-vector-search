package br.com.ricardohsmello.domain.service;

import br.com.ricardohsmello.application.request.MovieRequest;

import java.util.List;

public interface OpenAIService {
  List<Double> getEmbedding(MovieRequest request);
}
