package pl.patrykdobrowolski.togglah.server.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.patrykdobrowolski.togglah.server.core.exp.KeyNotFoundException;
import pl.patrykdobrowolski.togglah.server.core.exp.ToggleService;
import pl.patrykdobrowolski.togglah.server.core.exp.ValueParsingException;
import pl.patrykdobrowolski.togglah.server.core.model.Toggle;
import pl.patrykdobrowolski.togglah.server.rest.dto.ToggleDto;
import pl.patrykdobrowolski.togglah.server.rest.dto.ToggleValueDto;
import pl.patrykdobrowolski.togglah.server.rest.dto.converter.ToggleConverter;

@RestController
@RequestMapping("/rest/toggles")
@RequiredArgsConstructor
public class TogglesResource {

    private final ToggleConverter toggleConverter;
    private final ToggleService toggleService;

    @PutMapping("{toggleKey}")
    public ToggleDto setToggle(@PathVariable("toggleKey") String key, @RequestBody ToggleValueDto value) throws KeyNotFoundException, ValueParsingException {
        Toggle setValue = toggleService.setValue(key, value.getValue());
        return toggleConverter.toDto(setValue);
    }

    @GetMapping("{toggleKey}")
    public ToggleDto getToggle(@PathVariable("toggleKey") String key) throws KeyNotFoundException {
        Toggle value = toggleService.getValue(key);
        return toggleConverter.toDto(value);
    }
}
