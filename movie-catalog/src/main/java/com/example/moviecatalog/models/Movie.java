package com.example.moviecatalog.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Movie {
    private String movieId;
    private String name;
    private String description;
}
