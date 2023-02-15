package com.deke.testredisdbjpa.testRabbitMq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    //TODO : MESAJI BAŞKA BİR UYGULAMADAN YAKALA BAKALIM.


    @RabbitListener(queues = "queue")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + "1>");
    }

    @RabbitListener(queues = "queue")
    public void receiveMessage1(String message) {
        System.out.println("Received <" + message + "2>");
    }

    @RabbitListener(queues = "queue")
    public void receiveMessage2(String message) {
        System.out.println("Received <" + message + "3>");
    }

    @RabbitListener(queues = "queue1")
    public void receiveMessage3(String message) {
        System.out.println(message);
    }

    @RabbitListener(queues = "queue1")
    public void receiveMessage4(String message) {
        System.out.println(message);
    }

}
