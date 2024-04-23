package br.com.ricardohsmello.infrastructure.config;

import jakarta.inject.Singleton;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Singleton
public class OpenAIConfig {

    @ConfigProperty(name = "openai.base.url")
    String openaiUrl;

    @ConfigProperty(name = "openai.bearer.token")
    String token;

    @ConfigProperty(name = "openai.bearer.model")
    String model;

    public String getOpenaiUrl() {
        return openaiUrl;
    }

    public String getToken() {
        return token;
    }

    public String getModel() {
        return model;
    }
}


