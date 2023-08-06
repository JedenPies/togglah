package pl.jedenpies.togglah.server.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.jedenpies.togglah.repository.MemDefinitionsRepository;
import pl.jedenpies.togglah.repository.MemTogglesRepository;
import pl.jedenpies.togglah.server.core.req.DefinitionsRepository;
import pl.jedenpies.togglah.server.core.req.TogglesRepository;

@Configuration
public class CommonBeansFactory {

    @Bean
    public DefinitionsRepository definitionsRepository() {
        return new MemDefinitionsRepository();
    }
    
    @Bean
    public TogglesRepository togglesRepository() {
        return new MemTogglesRepository();
    }
}
