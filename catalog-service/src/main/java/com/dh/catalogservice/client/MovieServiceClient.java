package com.dh.catalogservice.client;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author vaninagodoy
 */

@FeignClient(name="movie-service")
public interface MovieServiceClient {

    @GetMapping("/movies/{genre}")
    List<MovieDto> getMovieByGenre(@PathVariable(value = "genre") String genre);

    @Getter
    @Setter
    class MovieDto{
        private Long id;

        private String name;

        private String genre;

        private String urlStream;
    }

}
