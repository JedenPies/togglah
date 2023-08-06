package pl.patrykdobrowolski.togglah.server.core.exp;

import java.util.Collection;

import pl.patrykdobrowolski.togglah.server.core.model.Definition;

public interface DefinitionService {

    void define(Definition definition) throws KeyAlreadyDefinedException;
    Definition find(String definitionKey) throws KeyNotFoundException;
    Collection<Definition> getAll();
    Definition remove(String definitionKey) throws KeyNotFoundException;

}
