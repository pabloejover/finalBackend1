package com.dh.catalogservice.queue;

import com.dh.catalogservice.client.MovieServiceClient;
import com.dh.catalogservice.domain.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Queue;


@Component
@RequiredArgsConstructor
public class MovieSender {
    private final MovieServiceClient client;
    private final RabbitTemplate rabbitTemplate;

    private final Queue movieQueue;

    public void send(Movie movie) {
        this.rabbitTemplate.convertAndSend(this.movieQueue.getName(), movie);
    }
}
