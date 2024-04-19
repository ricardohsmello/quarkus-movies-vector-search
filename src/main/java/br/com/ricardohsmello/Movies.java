package br.com.ricardohsmello;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;

import java.util.List;

@Entity("movies")
public record Movies(
        @Column String plot,
        @Column List<String> languages,
        @Column int year
) {
}
