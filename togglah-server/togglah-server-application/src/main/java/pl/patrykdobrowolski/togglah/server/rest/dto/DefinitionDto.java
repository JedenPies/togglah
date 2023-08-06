package pl.patrykdobrowolski.togglah.server.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;

@Getter
public class DefinitionDto {

    private final String key;
    private final String type;

    @JsonCreator
    @Builder
    public DefinitionDto(@JsonProperty("key") String key, @JsonProperty("type") String type) {
        this.key = key;
        this.type = type;
    }
}
