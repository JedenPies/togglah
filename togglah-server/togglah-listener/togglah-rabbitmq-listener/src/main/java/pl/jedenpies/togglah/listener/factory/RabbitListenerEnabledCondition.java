package pl.jedenpies.togglah.listener.factory;

import static java.util.Optional.ofNullable;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class RabbitListenerEnabledCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return ofNullable(context.getEnvironment().getProperty("spring.togglah.listener.rabbitmq.enabled", Boolean.class))
                .orElse(false);
    }

}
