package pl.patrykdobrowolski.togglah.server.core.types;

import jakarta.inject.Named;
import pl.patrykdobrowolski.togglah.server.core.exp.ValueParsingException;
import pl.patrykdobrowolski.togglah.server.core.model.ToggleType;

@Named
public class StringToggleType implements ToggleType<String> {

    @Override
    public String getKey() {
        return "string";
    }

    @Override
    public String parse(String value) throws ValueParsingException {
        return value;
    }
}
