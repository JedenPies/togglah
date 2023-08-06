package pl.patrykdobrowolski.togglah.server.core.req;

import pl.patrykdobrowolski.togglah.server.core.model.Toggle;

public interface ToggleValueListener {

    void valueChanged(Toggle toggle);

}
