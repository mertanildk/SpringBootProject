package com.deke.testredisdbjpa.testRabbitMq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfigs {


    @Value("${sr.rabbit.queue.name}")
    private String queueName;


    @Value("${sr.rabbit.queue.name2}")
    private String queueName2;

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;


    /**
     * The queue() function creates a queue with the name "my-queue" and durable set to true
     *
     * @return A queue object
     */
    @Bean
    public Queue queue() {
        return new Queue(queueName, true);
    }

    @Bean
    public Queue queue2() {return new Queue(queueName2, true);}

    /**
     * The function creates a direct exchange with the name of the exchangeName variable
     *
     * @return A DirectExchange object.
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(exchangeName);
    }

    /**
     * Bind the queue to the exchange with the routing key.
     *
     * @param queue          The name of the queue.
     * @param directExchange The exchange to which the queue is bound.
     * @return A Binding object.
     */
    @Bean
    public Binding binding(final Queue queue, final DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with(routingName);
    }
}
