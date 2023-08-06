package pl.patrykdobrowolski.togglah.server.core.exp;

@SuppressWarnings("serial")
public class KeyNotFoundException extends Exception {

    private static final String MESSAGE = "Toggle defintion with key %s not found.";

    public KeyNotFoundException(String key) {
        super(MESSAGE.formatted(key));
    }
}
