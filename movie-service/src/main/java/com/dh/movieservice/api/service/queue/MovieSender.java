package com.dh.movieservice.api.service.queue;

import com.dh.movieservice.domain.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


@Component

public class MovieSender {

    private final RabbitTemplate rabbitTemplate;

    public MovieSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(Movie movie) {

        this.rabbitTemplate.convertAndSend("BackExch", "com.dh.backend.movieload", movie);

    }

}
