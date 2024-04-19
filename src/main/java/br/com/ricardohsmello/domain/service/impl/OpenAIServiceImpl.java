package br.com.ricardohsmello.domain.service.impl;

import br.com.ricardohsmello.application.request.MovieRequest;
import br.com.ricardohsmello.application.response.EmbeddingResponse;
import br.com.ricardohsmello.domain.service.OpenAIService;
import br.com.ricardohsmello.infrastructure.gateway.OpenAIGateway;
import br.com.ricardohsmello.infrastructure.request.OpenAIRequest;
import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.net.URI;
import java.util.List;

@ApplicationScoped
public class OpenAIServiceImpl implements OpenAIService {

    @ConfigProperty(name = "openai.base.url")
    String openaiUrl;

    @ConfigProperty(name = "openai.bearer.token")
    String token;

    @ConfigProperty(name = "openai.bearer.model")
    String model;

    @Override
    public List<Double> getEmbedding(MovieRequest request) {
        var openAiGateway = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(openaiUrl))
                .build(OpenAIGateway.class);

        OpenAIRequest openAIRequest = new OpenAIRequest(request.getQuestion(), model);

        var embedding = openAiGateway.embedding(openAIRequest, token);

        return embedding.getData().getFirst().getEmbedding();
    }
}
