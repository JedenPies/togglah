package pl.patrykdobrowolski.togglah.server.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import pl.patrykdobrowolski.togglah.server.core.exp.KeyAlreadyDefinedException;
import pl.patrykdobrowolski.togglah.server.core.exp.KeyNotFoundException;
import pl.patrykdobrowolski.togglah.server.core.exp.ValueParsingException;
import pl.patrykdobrowolski.togglah.server.rest.dto.ErrorDto;
import pl.patrykdobrowolski.togglah.server.rest.dto.exception.ValidationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(KeyAlreadyDefinedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorDto alreadyDefinedExceptionHandler(KeyAlreadyDefinedException exception) {
        return ErrorDto.builder().message(exception.getMessage()).build();
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto validationExceptionHandler(ValidationException exception) {
        return ErrorDto.builder().message(exception.getMessage()).build();
    }

    @ExceptionHandler(KeyNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto keyNotFoundExceptionHandler(KeyNotFoundException exception) {
        return ErrorDto.builder().message(exception.getMessage()).build();
    }

    @ExceptionHandler(ValueParsingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto valueParsingExceptionHandler(ValueParsingException exception) {
        return ErrorDto.builder().message(exception.getMessage()).build();
    }
}
