package com.dh.catalogservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Bean
    public TopicExchange appExchange() {
        return new TopicExchange("backendExchage");
    }

    @Bean
    public Queue queueMovie() {
        return new Queue("NewMovie");
    }

    @Bean
    public Queue queueSerie() {
        return new Queue("NewSerie");
    }

    @Bean
    public Binding bindingMovieCreated() {
        return BindingBuilder.bind(queueMovie()).to(appExchange()).with("com.dh.backend.moviecreated");
    }

    @Bean
    public Binding bindingSerieCreated() {
        return BindingBuilder.bind(queueSerie()).to(appExchange()).with("com.dh.backend.seriecreated");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }



}
