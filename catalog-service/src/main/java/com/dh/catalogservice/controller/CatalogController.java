package com.dh.catalogservice.controller;

import com.dh.catalogservice.client.MovieServiceClient;
import com.dh.catalogservice.client.SerieServiceClient;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author vaninagodoy
 */

@RestController
//@RequiredArgsConstructor
@RequestMapping("/catalog")
public class CatalogController {

//    private final MovieSender movieSender;
//    private final SerieSender serieSender;

    private final MovieServiceClient movieServiceClient;
    private final SerieServiceClient serieServiceClient;

    public CatalogController(MovieServiceClient movieServiceClient, SerieServiceClient serieServiceClient/*,MovieSender movieSender, SerieSender serieSender*/) {
        this.movieServiceClient = movieServiceClient;
        this.serieServiceClient = serieServiceClient;
//        this.movieSender = movieSender;
//        this.serieSender = serieSender;

    }

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
//    @PostMapping("/movies/salvar")
//    public void saveMovie(@RequestBody Movie movie) {
//        movieSender.send(movie);
//    }
//
//    @PostMapping("/series/salvar")
//    public void saveSerie(@RequestBody Serie serie) {serieSender.send(serie);    }


}
