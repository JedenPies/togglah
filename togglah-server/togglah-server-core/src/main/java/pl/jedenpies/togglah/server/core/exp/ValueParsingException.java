package pl.jedenpies.togglah.server.core.exp;

@SuppressWarnings("serial")
public class ValueParsingException extends Exception {

    private static final String MESSAGE = "Cannot parse value %s to type %s.";

    public ValueParsingException(String valueToParse, String expectedType) {
        super(MESSAGE.formatted(valueToParse, expectedType));
    }
}
