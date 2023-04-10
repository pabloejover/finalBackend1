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

    @GetMapping("/series/{genre}")
    SerieDTO getSerieByGenre (@PathVariable String genre){

        List<SerieServiceClient.SerieDTO> serie = serieServiceClient.getSerieByGenre(genre);
        SerieDTO serieDTO = new SerieDTO(serie);
        return serieDTO;
    }

    @GetMapping("/movies/{genre}")
    MovieDTO getMovieByGenre (@PathVariable String genre){

        List<MovieServiceClient.MovieDTO> movie = movieServiceClient.getMovieByGenre(genre);

        MovieDTO movieDTO = new MovieDTO(movie);
        return movieDTO;
    }
    
    @Getter
    @Setter
    @Builder
    static class SerieDTO{
        private List<SerieServiceClient.SerieDTO> series;
    }

    @Getter
    @Setter
    @Builder
    static class MovieDTO{
        private List<MovieServiceClient.MovieDTO> movies;

    }

}
