package com.dh.catalogservice.queue;

import com.dh.catalogservice.client.MovieServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MovieListener {

    @RabbitListener(queues = "NewMovie")
    public void Listen(MovieServiceClient.MovieDTO movieDTO) {

        System.out.println(movieDTO.getName());
//        catalogService.createMovie(movieMessage);
    }

}
