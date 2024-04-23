package br.com.ricardohsmello.domain.gateway;

import java.util.List;

public interface OpenAIGateway {
  List<Double> getEmbedding(String input);
}
