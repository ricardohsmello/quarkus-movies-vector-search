package br.com.ricardohsmello.domain.service.impl;

import br.com.ricardohsmello.application.config.OpenAIConfig;
import br.com.ricardohsmello.application.request.MovieRequest;
import br.com.ricardohsmello.domain.service.OpenAIService;
import br.com.ricardohsmello.infrastructure.gateway.OpenAIGateway;
import br.com.ricardohsmello.infrastructure.request.OpenAIRequest;
import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.net.URI;
import java.util.List;

@ApplicationScoped
public class OpenAIServiceImpl implements OpenAIService {

    @Inject
    OpenAIConfig openAiConfig;

    @Override
    public List<Double> getEmbedding(MovieRequest request) {
        var openAiGateway = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(openAiConfig.getOpenaiUrl()))
                .build(OpenAIGateway.class);

        var embedding = openAiGateway.embedding(
                new OpenAIRequest(request.question(), openAiConfig.getModel()),
                openAiConfig.getToken()
        );

        return embedding.data().getFirst().embedding();
    }
}
