package pl.patrykdobrowolski.togglah.server.rest.dto.exception;

@SuppressWarnings("serial")
public class ValidationException extends Exception {

    public ValidationException(String message) {
        super(message);
    }
}
