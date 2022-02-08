package com.example.moviecatalog.utills;

import com.example.moviecatalog.models.Movie;
import com.example.moviecatalog.models.UserRating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MOVIE-INFO-SERVICE")
public interface MovieInfoConsumer {
    @GetMapping("/movie/{movieId}")
    Movie getMovieById(@PathVariable String movieId);
}
