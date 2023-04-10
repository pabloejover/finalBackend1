package com.dh.catalogservice.controller;

import com.dh.catalogservice.client.MovieServiceClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author vaninagodoy
 */

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final MovieServiceClient movieServiceClient;

    public CatalogController(MovieServiceClient movieServiceClient) {
        this.movieServiceClient = movieServiceClient;
    }

    @GetMapping("/{genre}")
    ResponseEntity<List<MovieServiceClient.MovieDto>> getGenre(@PathVariable String genre) {
        return ResponseEntity.ok(movieServiceClient.getMovieByGenre(genre));
    }
}
