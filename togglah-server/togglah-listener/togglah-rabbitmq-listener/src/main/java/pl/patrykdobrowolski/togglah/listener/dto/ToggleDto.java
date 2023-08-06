package pl.patrykdobrowolski.togglah.listener.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ToggleDto {

    private final String key;
    private final String type;
    private final Object value;
    private final Long version;
}
