package pl.patrykdobrowolski.togglah.server.rest;

import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.patrykdobrowolski.togglah.server.core.exp.DefinitionService;
import pl.patrykdobrowolski.togglah.server.core.exp.KeyAlreadyDefinedException;
import pl.patrykdobrowolski.togglah.server.core.exp.KeyNotFoundException;
import pl.patrykdobrowolski.togglah.server.core.model.Definition;
import pl.patrykdobrowolski.togglah.server.rest.dto.DefinitionDto;
import pl.patrykdobrowolski.togglah.server.rest.dto.converter.DefinitionConverter;
import pl.patrykdobrowolski.togglah.server.rest.dto.exception.ValidationException;

@RestController
@RequestMapping("rest/definitions")
@RequiredArgsConstructor
public class DefinitionsResource {

    private final DefinitionConverter definitionConverter;
    private final DefinitionService definitionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DefinitionDto addDefinition(@RequestBody DefinitionDto definitionDto) throws KeyAlreadyDefinedException, ValidationException {
        Definition definition = definitionConverter.fromDto(definitionDto);
        definitionService.define(definition);
        return definitionConverter.toDto(definition);
    }

    @GetMapping
    public List<DefinitionDto> getAllDefinitions() {
        Collection<Definition> definitions = definitionService.getAll();
        return definitions.stream()
                .map(definitionConverter::toDto)
                .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                .toList();
    }

    @DeleteMapping("{definitionKey}")
    public DefinitionDto removeDefinition(@PathVariable("definitionKey") String definitionKey) throws KeyNotFoundException {
        Definition removed = definitionService.remove(definitionKey);
        return definitionConverter.toDto(removed);
    }
}
