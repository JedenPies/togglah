package pl.patrykdobrowolski.togglah.server.core.req;

import pl.patrykdobrowolski.togglah.server.core.model.Definition;
import pl.patrykdobrowolski.togglah.server.core.model.Toggle;

public interface TogglesRepository {

    /**
     * 
     * @param key non-null toggle key
     * @param definition 
     * @return should always return value 
     */
    Toggle get(String key, Definition definition);
    Toggle save(Toggle toggle);

}
