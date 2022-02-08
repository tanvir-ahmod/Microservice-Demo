package com.example.moviecatalog.controller;

import com.example.moviecatalog.models.CatalogItem;
import com.example.moviecatalog.models.Movie;
import com.example.moviecatalog.models.UserRating;
import com.example.moviecatalog.utills.MovieInfoConsumer;
import com.example.moviecatalog.utills.MovieRatingsConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MovieCatalogController {

    private final MovieRatingsConsumer movieRatingsConsumer;
    private final MovieInfoConsumer movieInfoConsumer;

    @GetMapping("/catalog/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating userRating = movieRatingsConsumer.getRatingsByUserId(userId);

        return userRating.getRatings().stream()
                .map(rating -> {
                    Movie movie = movieInfoConsumer.getMovieById(rating.getMovieId());
                    return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
                })
                .collect(Collectors.toList());

    }
}
