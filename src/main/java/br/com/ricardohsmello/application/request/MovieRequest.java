package br.com.ricardohsmello.application.request;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public record MovieRequest(
    String search,
    Long limit){}