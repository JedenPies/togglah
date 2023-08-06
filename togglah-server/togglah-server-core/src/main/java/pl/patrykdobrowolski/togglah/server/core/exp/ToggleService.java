package pl.patrykdobrowolski.togglah.server.core.exp;

import pl.patrykdobrowolski.togglah.server.core.model.Toggle;

public interface ToggleService {

    Toggle setValue(String key, String value) throws KeyNotFoundException, ValueParsingException;
    Toggle getValue(String key) throws KeyNotFoundException;

}
