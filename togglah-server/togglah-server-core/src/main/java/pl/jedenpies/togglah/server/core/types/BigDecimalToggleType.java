package pl.jedenpies.togglah.server.core.types;

import java.math.BigDecimal;

import jakarta.inject.Named;
import pl.jedenpies.togglah.server.core.exp.ValueParsingException;
import pl.jedenpies.togglah.server.core.model.ToggleType;

@Named
public class BigDecimalToggleType implements ToggleType<BigDecimal> {

    @Override
    public String getKey() {
        return "number";
    }

    @Override
    public BigDecimal parse(String value) throws ValueParsingException {
        try {
            return new BigDecimal(value);
        } catch (NumberFormatException e) {
            throw new ValueParsingException(value, getKey());
        }
    }

}
