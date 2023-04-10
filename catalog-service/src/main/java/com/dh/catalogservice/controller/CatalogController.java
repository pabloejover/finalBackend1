package com.dh.catalogservice.controller;

import com.dh.catalogservice.client.MovieServiceClient;
import com.dh.catalogservice.client.SerieServiceClient;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
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
    private final SerieServiceClient serieServiceClient;

    public CatalogController(MovieServiceClient movieServiceClient, SerieServiceClient serieServiceClient) {
        this.movieServiceClient = movieServiceClient;
        this.serieServiceClient = serieServiceClient;
    }

//    @GetMapping("/{genre}")
//    ResponseEntity<List<MovieServiceClient.MovieDto>> getGenre(@PathVariable String genre) {
//        return ResponseEntity.ok(movieServiceClient.getMovieByGenre(genre));
//    }

    @GetMapping("/{genre}")
    MovieSerieDTO getSerieByGenre (@PathVariable String genre){

        List<MovieServiceClient.MovieDTO> movie = movieServiceClient.getMovieByGenre(genre);
        List<SerieServiceClient.SerieDTO> serie = serieServiceClient.getSerieByGenre(genre);
        MovieSerieDTO movieSerieDTO = new MovieSerieDTO(movie,serie);
        return movieSerieDTO;
    }
    @Getter
    @Setter
    @Builder
    static class MovieSerieDTO{
        private List<MovieServiceClient.MovieDTO> movies;
        private List<SerieServiceClient.SerieDTO> series;
    }
}
