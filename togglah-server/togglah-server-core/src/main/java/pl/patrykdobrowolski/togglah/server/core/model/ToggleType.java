package pl.patrykdobrowolski.togglah.server.core.model;

import pl.patrykdobrowolski.togglah.server.core.exp.ValueParsingException;

public interface ToggleType<T> {

    String getKey();
    T parse(String value) throws ValueParsingException;
}
