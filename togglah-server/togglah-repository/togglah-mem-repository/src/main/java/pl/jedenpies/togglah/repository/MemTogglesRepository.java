package pl.jedenpies.togglah.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import pl.jedenpies.togglah.server.core.model.Definition;
import pl.jedenpies.togglah.server.core.model.Toggle;
import pl.jedenpies.togglah.server.core.req.TogglesRepository;

public class MemTogglesRepository implements TogglesRepository {

    private final Map<String, Toggle> toggles = new HashMap<>();

    @Override
    public Toggle get(String key, Definition definition) {
        return Optional.ofNullable(toggles.get(key)).orElseGet(() -> emptyToggle(definition));
    }

    @Override
    public void save(Toggle toggle) {
        String key = toggle.getDefinition().getKey();
        toggles.put(key, toggle);
    }
    
    private Toggle emptyToggle(Definition definition) {
        return Toggle.builder()
            .definition(definition)
            .value(null)
            .build();
    }

}
