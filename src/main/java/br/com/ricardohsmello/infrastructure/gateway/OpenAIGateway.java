package br.com.ricardohsmello.infrastructure.gateway;


import br.com.ricardohsmello.infrastructure.response.OpenAIResponse;
import br.com.ricardohsmello.infrastructure.request.OpenAIRequest;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface OpenAIGateway {

    @POST
    OpenAIResponse embedding(OpenAIRequest request, @HeaderParam("Authorization") String authorization);
}
