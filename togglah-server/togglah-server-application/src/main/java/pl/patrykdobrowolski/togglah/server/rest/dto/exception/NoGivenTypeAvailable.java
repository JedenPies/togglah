package pl.patrykdobrowolski.togglah.server.rest.dto.exception;

@SuppressWarnings("serial")
public class NoGivenTypeAvailable extends ValidationException {

    private static final String MESSAGE = "Type %s not available";

    public NoGivenTypeAvailable(String typeKey) {
        super(MESSAGE.formatted(typeKey));
    }

}
