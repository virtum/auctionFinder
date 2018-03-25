package com.filocha.utils;

import com.filocha.messaging.client.ClientBus;
import com.filocha.messaging.client.ClientBusImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
// TODO move beans to separate classes
public class TempBeans {

    @Value("${dockerPort}")
    private String dockerPort;

    @Bean
    public ClientBus clientBus() {
        ClientBusImpl clientBus = new ClientBusImpl();
        clientBus.setConsumerAndProducer(dockerPort, "RESPONSE.QUEUE", "REQUEST.QUEUE");

        return clientBus;
    }
}
