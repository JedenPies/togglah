package pl.jedenpies.togglah.server.core.req;

import pl.jedenpies.togglah.server.core.model.Toggle;

public interface ToggleValueListener {

    void valueChanged(Toggle toggle);

}
