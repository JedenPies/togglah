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
    public synchronized Toggle save(Toggle toggle) {
        String key = toggle.getDefinition().getKey();
        Toggle newToggle = withIncrementedVersion(toggle);
        toggles.put(key, newToggle);
        return newToggle;
    }

    private Toggle withIncrementedVersion(Toggle toggle) {
        return Toggle.builder()
                .definition(toggle.getDefinition())
                .value(toggle.getValue())
                .version(Optional.ofNullable(toggle.getVersion()).map(v -> v + 1).orElse(1L))
                .build();
    }
    
    private Toggle emptyToggle(Definition definition) {
        return Toggle.builder()
            .definition(definition)
            .build();
    }
}
