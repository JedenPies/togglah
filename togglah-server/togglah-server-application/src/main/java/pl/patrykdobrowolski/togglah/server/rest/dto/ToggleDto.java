package pl.patrykdobrowolski.togglah.server.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ToggleDto {

    private final String type;
    private final Object value;
    private final Long version;
}
