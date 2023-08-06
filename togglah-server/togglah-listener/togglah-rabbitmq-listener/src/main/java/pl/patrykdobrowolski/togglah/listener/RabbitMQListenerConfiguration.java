package pl.patrykdobrowolski.togglah.listener;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class RabbitMQListenerConfiguration {

    private final String exchange;
    private final String routingKey;
    
}
