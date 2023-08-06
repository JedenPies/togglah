package pl.jedenpies.togglah.server.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class ToggleValueDto {

    private final String value;

    @JsonCreator
    public ToggleValueDto(@JsonProperty("value") String value) {
        this.value = value;
    }
}
