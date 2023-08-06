package pl.patrykdobrowolski.togglah.server.core.service;

import java.util.Collection;
import java.util.Optional;

import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;
import pl.patrykdobrowolski.togglah.server.core.exp.DefinitionService;
import pl.patrykdobrowolski.togglah.server.core.exp.KeyAlreadyDefinedException;
import pl.patrykdobrowolski.togglah.server.core.exp.KeyNotFoundException;
import pl.patrykdobrowolski.togglah.server.core.model.Definition;
import pl.patrykdobrowolski.togglah.server.core.req.DefinitionsRepository;

@RequiredArgsConstructor
@Named
public class DefinitionServiceImpl implements DefinitionService {

    private final DefinitionsRepository definitionsRepository;

    @Override
    public void define(Definition definition) throws KeyAlreadyDefinedException {
        String key = definition.getKey();
        Optional<Definition> found = definitionsRepository.getByKey(key);
        if (found.isPresent()) {
            throw new KeyAlreadyDefinedException(key);
        } else {
            definitionsRepository.save(definition);
        }
    }

    @Override
    public Collection<Definition> getAll() {
        return definitionsRepository.getAll();
    }

    @Override
    public Definition remove(String definitionKey) throws KeyNotFoundException {
        Definition definition = definitionsRepository.getByKey(definitionKey).orElseThrow(() -> new KeyNotFoundException(definitionKey));
        definitionsRepository.remove(definition);
        return definition;
    }

    @Override
    public Definition find(String definitionKey) throws KeyNotFoundException {
        return definitionsRepository.getByKey(definitionKey).orElseThrow(() -> new KeyNotFoundException(definitionKey));
    }
}
