package com.dh.catalogservice.queue;

import com.dh.catalogservice.client.SerieServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class SerieListener {
    @RabbitListener(queues = "NewSerie")
    public void Listen(SerieServiceClient.SerieDTO serieDTO) {

        System.out.println(serieDTO.getName());

    }

}
