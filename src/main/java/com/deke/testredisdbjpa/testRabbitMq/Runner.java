package com.deke.testredisdbjpa.testRabbitMq;

import lombok.RequiredArgsConstructor;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    @Override
    public void run(String... args) throws InterruptedException {
        System.out.println("Sending message...");
        Thread.sleep(5000);
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend(RabbitMqConfigs.EXCHANGE_NAME, "foo.bar.baz", "Hello from RabbitMQ!");
            receiver.getLatch().await(0, TimeUnit.MILLISECONDS);
        }
    }
}
