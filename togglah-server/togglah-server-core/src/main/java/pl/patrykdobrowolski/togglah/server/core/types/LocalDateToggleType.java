package pl.patrykdobrowolski.togglah.server.core.types;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import jakarta.inject.Named;
import pl.patrykdobrowolski.togglah.server.core.exp.ValueParsingException;
import pl.patrykdobrowolski.togglah.server.core.model.ToggleType;

@Named
public class LocalDateToggleType implements ToggleType<LocalDate> {

    @Override
    public String getKey() {
        return "date";
    }

    @Override
    public LocalDate parse(String value) throws ValueParsingException {
        try {
            return LocalDate.parse(value);
        } catch (DateTimeParseException e) {
            throw new ValueParsingException(value, getKey());
        }
    }

}
