package pl.jedenpies.togglah.listener.factory;

import java.text.SimpleDateFormat;
import java.util.Optional;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.RequiredArgsConstructor;
import pl.jedenpies.togglah.listener.RabbitMQListenerConfiguration;
import pl.jedenpies.togglah.listener.RabbitMQValueListener;

@Configuration
@Conditional(RabbitListenerEnabledCondition.class)
@RequiredArgsConstructor
public class RabbitMQListenerBeansFactory {

    private static final String PREFIX = "spring.togglah.listener.rabbitmq";

    @Value("${" + PREFIX + ".addresses}")
    private String addresses;
    @Value("${" + PREFIX + ".username:guest}")
    private String username;
    @Value("${" + PREFIX + ".password:}")
    private String password;
    @Value("${" + PREFIX + ".virtual-host:/}")
    private String virtualHost;
    @Value("${" + PREFIX + ".exchange:}")
    private String exchange;
    @Value("${" + PREFIX + ".routing-key:evt.togglah.value-changed}")
    private String routingKey;
    
    private final Optional<ConnectionFactory> connectionFactory;

    @Bean
    public RabbitMQValueListener rabbitMQValueListener() {
        return new RabbitMQValueListener(rabbitTemplate(), configuration());
    }

    private RabbitTemplate rabbitTemplate() {
        RabbitTemplate newRabbitTemplate = new RabbitTemplate(connectionFactory.orElseGet(this::connectionFactory));
        newRabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter(objectMapper()));
        return newRabbitTemplate;
    }

    private ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm a z"));
        return objectMapper;
    }
    
    private ConnectionFactory connectionFactory() {
        CachingConnectionFactory newConnectionFactory = new CachingConnectionFactory();
        newConnectionFactory.setAddresses(addresses);
        newConnectionFactory.setUsername(username);
        newConnectionFactory.setPassword(password);
        newConnectionFactory.setVirtualHost(virtualHost);
        return newConnectionFactory;
    }

    private RabbitMQListenerConfiguration configuration() {
        return new RabbitMQListenerConfiguration(exchange, routingKey);
    }

}
