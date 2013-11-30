package eu.hurion.tadaah.service;

import eu.hurion.tadaah.model.Todo;

import java.util.List;

public interface TodoRegistry {

    List<Todo> getTodos();

    Todo getTodo(Long id);
}
