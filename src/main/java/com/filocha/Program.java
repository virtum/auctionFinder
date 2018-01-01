package com.filocha;

import com.filocha.messaging.client.ClientBusImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableScheduling
public class Program {
    @Value("${dockerPort}")
    private String dockerPort;


    public static void main(String[] args) {
        SpringApplication.run(Program.class, args);
    }

    @Bean
    public ClientBusImpl getClientBusImplBean() {
        ClientBusImpl clientBus = new ClientBusImpl();
        clientBus.setConsumerAndProducer(dockerPort, "RESPONSE.QUEUE", "REQUEST.QUEUE");

        return clientBus;
    }
}
