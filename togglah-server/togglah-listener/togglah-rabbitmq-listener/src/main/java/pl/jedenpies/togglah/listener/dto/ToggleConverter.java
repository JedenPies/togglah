package pl.jedenpies.togglah.listener.dto;

import pl.jedenpies.togglah.server.core.model.Toggle;

public class ToggleConverter {

    public ToggleDto toDto(Toggle toggle) {
        return ToggleDto.builder()
            .key(toggle.getDefinition().getKey())
            .type(toggle.getDefinition().getType().getKey())
            .value(toggle.getValue())
            .version(toggle.getVersion())
            .build();
    }
}
