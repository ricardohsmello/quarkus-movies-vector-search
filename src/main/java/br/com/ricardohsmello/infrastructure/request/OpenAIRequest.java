package br.com.ricardohsmello.infrastructure.request;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class OpenAIRequest {
    private String input;
    private String model;

    public OpenAIRequest() {
    }

    public OpenAIRequest(String input, String model) {
        this.input = input;
        this.model = model;
    }

    public String getInput() {
        return input;
    }

    public String getModel() {
        return model;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setModel(String model) {
        this.model = model;
    }
}