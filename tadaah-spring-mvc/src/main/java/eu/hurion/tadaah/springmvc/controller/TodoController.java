package eu.hurion.tadaah.springmvc.controller;

import eu.hurion.tadaah.model.Todo;
import eu.hurion.tadaah.service.TodoRegistry;
import eu.hurion.tadaah.springmvc.dto.TodoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {

    @Autowired
    private TodoRegistry todoRegistry;

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    public @ResponseBody List<TodoDTO> getToDoList() {
        final List<Todo> todos = todoRegistry.getTodos();
        final List<TodoDTO> result = new ArrayList<>(todos.size());
        for (Todo todo : todos) {
            result.add(new TodoDTO(todo));
        }
        return result;
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
    public @ResponseBody
    TodoDTO getToDo(@PathVariable Long id) {
        final Todo todo = todoRegistry.getTodo(id);
        return new TodoDTO(todo);
    }

    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    public @ResponseBody Todo save(@RequestBody TodoDTO todo){
        final Todo savedTodo = todoRegistry.save(todo);
        TodoDTO dto = new TodoDTO(savedTodo);
        return dto;
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
    public void deleteToDo(@PathVariable Long id) {
    }

    public void setTodoRegistry(final TodoRegistry todoRegistry) {
        this.todoRegistry = todoRegistry;
    }
}
