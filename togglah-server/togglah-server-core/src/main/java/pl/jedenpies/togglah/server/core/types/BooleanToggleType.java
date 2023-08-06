package pl.jedenpies.togglah.server.core.types;

import jakarta.inject.Named;
import pl.jedenpies.togglah.server.core.exp.ValueParsingException;
import pl.jedenpies.togglah.server.core.model.ToggleType;

@Named
public class BooleanToggleType implements ToggleType<Boolean> {

    @Override
    public String getKey() {
        return "boolean";
    }

    @Override
    public Boolean parse(String value) throws ValueParsingException {
        Boolean parsed = Boolean.valueOf(value);
        if (!parsed.toString().equals(value)) {
            throw new ValueParsingException(value, this.getKey());
        }
        return parsed;
    }
}
