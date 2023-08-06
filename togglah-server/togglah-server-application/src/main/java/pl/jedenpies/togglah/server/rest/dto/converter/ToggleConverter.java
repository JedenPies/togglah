package pl.jedenpies.togglah.server.rest.dto.converter;

import org.springframework.stereotype.Component;

import pl.jedenpies.togglah.server.core.model.Toggle;
import pl.jedenpies.togglah.server.rest.dto.ToggleDto;

@Component
public class ToggleConverter {

    public ToggleDto toDto(Toggle toggle) {
        return ToggleDto.builder()
            .type(toggle.getDefinition().getType().getKey())
            .value(toggle.getValue())
            .build();
    }
}
