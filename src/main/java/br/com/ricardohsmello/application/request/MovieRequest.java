package br.com.ricardohsmello.application.request;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class MovieRequest {
    private String question;
    private Long limit;

    public MovieRequest() {
    }

    public MovieRequest(String question, Long limit) {
        this.question = question;
        this.limit = limit;
    }


    public String getQuestion() {
        return question;
    }

    public Long getLimit() {
        return limit;
    }
}