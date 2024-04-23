package br.com.ricardohsmello.infrastructure.gateway;

import br.com.ricardohsmello.domain.gateway.OpenAIGateway;
import br.com.ricardohsmello.infrastructure.config.OpenAIConfig;
import br.com.ricardohsmello.infrastructure.request.OpenAIRequest;
import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.net.URI;
import java.util.List;

@ApplicationScoped
public class OpenAIGatewayImpl implements OpenAIGateway {

    @Inject OpenAIConfig openAIConfig;

    @Override
    public List<Double> getEmbedding(String input) {
        var openAiGateway = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(openAIConfig.getOpenaiUrl()))
                .build(OpenAIRestClient.class);

        var embedding = openAiGateway.embedding(
                new OpenAIRequest(input, openAIConfig.getModel()),
                openAIConfig.getToken()
        );

        return embedding.data().getFirst().embedding();
    }
}
