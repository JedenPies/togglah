package pl.jedenpies.togglah.server.core.req;

import java.util.Collection;
import java.util.Optional;

import pl.jedenpies.togglah.server.core.model.Definition;

public interface DefinitionsRepository {

    Optional<Definition> getByKey(String key);
    void save(Definition definition);
    Collection<Definition> getAll();
    void remove(Definition definition);

}
