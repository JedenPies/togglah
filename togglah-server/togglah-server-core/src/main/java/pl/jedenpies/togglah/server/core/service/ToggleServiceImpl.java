package pl.jedenpies.togglah.server.core.service;

import java.util.List;
import java.util.Objects;

import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;
import pl.jedenpies.togglah.server.core.exp.KeyNotFoundException;
import pl.jedenpies.togglah.server.core.exp.ToggleService;
import pl.jedenpies.togglah.server.core.exp.ValueParsingException;
import pl.jedenpies.togglah.server.core.model.Definition;
import pl.jedenpies.togglah.server.core.model.Toggle;
import pl.jedenpies.togglah.server.core.req.DefinitionsRepository;
import pl.jedenpies.togglah.server.core.req.ToggleValueListener;
import pl.jedenpies.togglah.server.core.req.TogglesRepository;

@Named
@RequiredArgsConstructor
public class ToggleServiceImpl implements ToggleService {

    private final DefinitionsRepository definitionsRepository;
    private final TogglesRepository togglesRepository;
    private final List<ToggleValueListener> valueListeners;

    @Override
    public Toggle setValue(String key, String value) throws KeyNotFoundException, ValueParsingException {
        Definition definition = definitionsRepository.getByKey(key).orElseThrow(() -> new KeyNotFoundException(key));
        Object parsedValue = definition.getType().parse(value);
        Toggle toggle = togglesRepository.get(key, definition);
        Object oldValue = toggle.getValue();
        if (!Objects.equals(parsedValue, oldValue)) {
            toggle.setValue(parsedValue);
            togglesRepository.save(toggle);
            valueListeners.stream().forEach(l -> l.valueChanged(toggle));
        }
        return toggle;
    }

    @Override
    public Toggle getValue(String key) throws KeyNotFoundException {
        Definition definition = definitionsRepository.getByKey(key).orElseThrow(() -> new KeyNotFoundException(key));
        return togglesRepository.get(key, definition);
    }
}
