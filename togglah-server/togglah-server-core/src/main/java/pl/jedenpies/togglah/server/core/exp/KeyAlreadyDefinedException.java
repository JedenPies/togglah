package pl.jedenpies.togglah.server.core.exp;

@SuppressWarnings("serial")
public class KeyAlreadyDefinedException extends Exception {

    private static final String MESSAGE = "Key %s already defined.";

    public KeyAlreadyDefinedException(String key) {
        super(MESSAGE.formatted(key));
    }
}
