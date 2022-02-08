package com.example.moviecatalog.utills;

import com.example.moviecatalog.models.UserRating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="MOVIE-RATINGS-SERVICE")
public interface MovieRatingsConsumer {
    @GetMapping("/user/{userId}")
    public UserRating getRatingsByUserId(@PathVariable String userId);
}
