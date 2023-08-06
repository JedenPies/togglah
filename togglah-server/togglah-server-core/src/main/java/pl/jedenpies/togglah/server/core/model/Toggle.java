package pl.jedenpies.togglah.server.core.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class Toggle {

    private final Definition definition;

    @Setter
    private Object value;
    private Long version;
}
