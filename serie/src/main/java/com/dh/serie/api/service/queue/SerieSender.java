package com.dh.serie.api.service.queue;


import com.dh.serie.model.Serie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component

public class SerieSender {

    private final RabbitTemplate rabbitTemplate;

    public SerieSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(Serie serie) {

        this.rabbitTemplate.convertAndSend("BackExch", "com.dh.backend.serieload", serie);

    }

}
