package pl.jedenpies.togglah.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import pl.jedenpies.togglah.server.core.model.Definition;
import pl.jedenpies.togglah.server.core.req.DefinitionsRepository;

public class MemDefinitionsRepository implements DefinitionsRepository {

    private final Map<String, Definition> definitions = new HashMap<>();
    
    @Override
    public Optional<Definition> getByKey(String key) {
        return Optional.ofNullable(definitions.get(key));
    }

    @Override
    public void save(Definition definition) {
        definitions.put(definition.getKey(), definition);
    }

    @Override
    public Collection<Definition> getAll() {
        return definitions.values();
    }

    @Override
    public void remove(Definition definition) {
        definitions.remove(definition.getKey());
    }

}
