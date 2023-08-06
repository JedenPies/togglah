package pl.patrykdobrowolski.togglah.server.core.service;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import jakarta.inject.Named;
import pl.patrykdobrowolski.togglah.server.core.model.ToggleType;

@Named
public class ToggleTypesProvider {

    private final Map<String, ToggleType<?>> toggleTypes;

    public ToggleTypesProvider(List<? extends ToggleType<?>> allTypes) {
        this.toggleTypes = allTypes.stream().collect(toMap(ToggleType::getKey, t -> t));
    }

    public Optional<ToggleType<?>> getByKey(String typeKey) {
        return ofNullable(toggleTypes.get(typeKey));
    }
}
