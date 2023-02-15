package com.deke.testredisdbjpa.testRabbitMq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final String routingName = "routingKey";
    private final String exchangeName = "exchange";

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... args) throws InterruptedException {
        System.out.println("Sending message every 2 seconds...");
        while (true){
            Thread.sleep(10);
            rabbitTemplate.convertAndSend(exchangeName, routingName, "Hello World!");
        }

    }
}
