package com.dh.catalogservice.api.client;

import com.dh.catalogservice.domain.model.Movies;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "movie-service")
public interface IMoviesServiceClient {
    @GetMapping("/movies/{genre}")
    ResponseEntity<List<Movies>> getMoviesByGenre(@PathVariable String genre);
}