package pl.jedenpies.togglah.server.rest.dto.converter;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import pl.jedenpies.togglah.server.core.model.Definition;
import pl.jedenpies.togglah.server.core.model.ToggleType;
import pl.jedenpies.togglah.server.core.service.ToggleTypesProvider;
import pl.jedenpies.togglah.server.rest.dto.DefinitionDto;
import pl.jedenpies.togglah.server.rest.dto.exception.NoGivenTypeAvailable;
import pl.jedenpies.togglah.server.rest.dto.exception.ValidationException;

@Component
@RequiredArgsConstructor
public class DefinitionConverter {

    private final ToggleTypesProvider typesProvider;

    public Definition fromDto(DefinitionDto dto) throws ValidationException {
        validateKey(dto);
        ToggleType<?> type = typesProvider.getByKey(dto.getType()).orElseThrow(() -> new NoGivenTypeAvailable(dto.getType()));
        return Definition.builder()
            .key(dto.getKey())
            .type(type)
            .build();
    }

    public DefinitionDto toDto(Definition definition) {
        return DefinitionDto.builder()
            .key(definition.getKey())
            .type(definition.getType().getKey())
            .build();
    }

    private void validateKey(DefinitionDto dto) throws ValidationException {
        if (dto.getKey() == null || dto.getKey().isBlank()) {
            throw new ValidationException("Key cannot be empty");
        }
    }
}
