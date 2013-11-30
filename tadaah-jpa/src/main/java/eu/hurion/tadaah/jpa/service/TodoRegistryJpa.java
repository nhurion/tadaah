package eu.hurion.tadaah.jpa.service;

import eu.hurion.tadaah.jpa.model.TodoJpa;
import eu.hurion.tadaah.model.Todo;
import eu.hurion.tadaah.service.TodoRegistry;

import java.util.ArrayList;
import java.util.List;

public class TodoRegistryJpa implements TodoRegistry {
    @Override
    public List<Todo> getTodos() {
        List<Todo> result = new ArrayList<>();
        result.add(new TodoJpa(1l, "Getting the todo list"));
        result.add(new TodoJpa(2l, "adding a new todo"));
        result.add(new TodoJpa(3l, "adding a new todo"));
        return result;
    }

    @Override
    public Todo getTodo(final Long id) {
        return new TodoJpa(id, "the todo with id " + id);
    }
}
