package com.dh.catalogservice.client;


import com.dh.catalogservice.config.LoadBalanceConfiguration;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author vaninagodoy
 */

@FeignClient(name="movie-service")
@LoadBalancerClient(name = "movie-service", configuration = LoadBalanceConfiguration.class)
public interface MovieServiceClient {

    @GetMapping("/movies/{genre}")
    List<MovieDTO> getMovieByGenre(@PathVariable(value = "genre") String genre);

    @Getter
    @Setter
    class MovieDTO{
        private Long id;

        private String name;

        private String genre;

        private String urlStream;
    }

}
