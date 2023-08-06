package pl.jedenpies.togglah.repository;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MemoryDatabaseSelectedCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return "memory".equals(context.getEnvironment().getProperty("spring.togglah.repository.type", String.class));
    }

}
