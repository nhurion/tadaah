package eu.hurion.tadaah.jpa.service;

import eu.hurion.tadaah.jpa.model.TodoJpa;
import eu.hurion.tadaah.model.Todo;
import eu.hurion.tadaah.service.TodoRegistry;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TodoRegistryJpa implements TodoRegistry {

    @Autowired
    private TodoRegistrySpringData springDataRegistry;

    @Override
    public List<Todo> getTodos() {
        final Iterable<TodoJpa> all = springDataRegistry.findAll();
        List<Todo> result = new ArrayList<>();
        for (TodoJpa todoJpa : all) {
            result.add(todoJpa);
        }
        return result;
    }

    @Override
    public Todo getTodo(final Long id) {
//        return springDataRegistry.findOne(id);
        return new TodoJpa(id, "the todo with id " + id);
    }

    @Override
    public Todo save(final Todo todo) {
        TodoJpa saveInstance;
        if (todo instanceof TodoJpa){
            saveInstance = (TodoJpa) todo;
        } else {
            saveInstance = new TodoJpa(todo.getId(),todo.getTitle());
        }
        return springDataRegistry.save(saveInstance);
    }

    public void setSpringDataRegistry(final TodoRegistrySpringData springDataRegistry) {
        this.springDataRegistry = springDataRegistry;
    }
}
