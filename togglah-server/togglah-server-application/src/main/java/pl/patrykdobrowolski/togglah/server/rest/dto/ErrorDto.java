package pl.patrykdobrowolski.togglah.server.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorDto {

    private final String message;
}
