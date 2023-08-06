package pl.jedenpies.togglah.listener;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import lombok.RequiredArgsConstructor;
import pl.jedenpies.togglah.listener.dto.ToggleConverter;
import pl.jedenpies.togglah.listener.dto.ToggleDto;
import pl.jedenpies.togglah.server.core.model.Toggle;
import pl.jedenpies.togglah.server.core.req.ToggleValueListener;

@RequiredArgsConstructor
public class RabbitMQValueListener implements ToggleValueListener {

    private final ToggleConverter toggleConverter = new ToggleConverter();
    private final RabbitTemplate rabbitTemplate;
    private final RabbitMQListenerConfiguration configuration;

    @Override
    public void valueChanged(Toggle toggle) {
        ToggleDto message = toggleConverter.toDto(toggle);
        rabbitTemplate.convertAndSend(configuration.getExchange(), configuration.getRoutingKey(), message);
    }

}
