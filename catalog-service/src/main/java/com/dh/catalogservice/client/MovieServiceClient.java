package com.dh.catalogservice.client;


import com.dh.catalogservice.config.LoadBalanceConfiguration;
import com.dh.catalogservice.domain.model.Movie;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

/**
 * @author vaninagodoy
 */

@FeignClient(name="movie-service",url = "http://localhost:8001")
@LoadBalancerClient(name = "movie-service", configuration = LoadBalanceConfiguration.class)
public interface MovieServiceClient {

    @GetMapping("/api/v1/movies/{genre}")
    List<MovieDTO> getMovieByGenre(@PathVariable(value = "genre") String genre);

    @Getter
    @Setter
    class MovieDTO{
        private Long id;

        private String name;

        private String genre;

        private String urlStream;
    }

    @PostMapping("/api/v1/movies/salvar")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie);

}
