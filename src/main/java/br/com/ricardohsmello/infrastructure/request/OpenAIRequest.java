package br.com.ricardohsmello.infrastructure.request;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public record OpenAIRequest(
        String input,
        String model){}