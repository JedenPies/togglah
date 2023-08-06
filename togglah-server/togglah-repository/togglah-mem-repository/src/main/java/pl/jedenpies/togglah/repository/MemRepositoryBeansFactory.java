package pl.jedenpies.togglah.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import pl.jedenpies.togglah.server.core.req.DefinitionsRepository;
import pl.jedenpies.togglah.server.core.req.TogglesRepository;

@Configuration
@Conditional(MemoryDatabaseSelectedCondition.class)
public class MemRepositoryBeansFactory {

    @Bean
    public DefinitionsRepository definitionsRepository() {
        return new MemDefinitionsRepository();
    }
    
    @Bean
    public TogglesRepository togglesRepository() {
        return new MemTogglesRepository();
    }
}
