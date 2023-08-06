package pl.jedenpies.togglah.server.core.req;

import pl.jedenpies.togglah.server.core.model.Definition;
import pl.jedenpies.togglah.server.core.model.Toggle;

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
