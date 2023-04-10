package com.dh.serie.api.service.queue;

import com.dh.serie.api.service.SerieService;
import com.dh.serie.model.Serie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SerieListener {
    private final SerieService service;

    @RabbitListener(queues = { "${queue.serie.name}" })
    public void receive(@Payload Serie serie) {
        service.create(serie);
    }
}
