package pl.patrykdobrowolski.togglah.server.core.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Definition {

    private final String key;
    private final ToggleType<?> type;
}
