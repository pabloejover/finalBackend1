package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.client.IMoviesServiceClient;
import com.dh.catalogservice.domain.model.Movies;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RequestMapping("/catalog")
@RestController
public class CatalogController {

    private final IMoviesServiceClient iMoviesServiceClient;

    public CatalogController(IMoviesServiceClient iMoviesServiceClient) {
        this.iMoviesServiceClient = iMoviesServiceClient;
    }

    @GetMapping("/{catalog}")
    ResponseEntity<List<Movies>> getCatalog(@PathVariable String catalog) {
        return iMoviesServiceClient.getMoviesByGenre(catalog);
    }




}
