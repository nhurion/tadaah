package eu.hurion.tadaah.springmvc.controller;

import eu.hurion.tadaah.model.Todo;
import eu.hurion.tadaah.service.TodoRegistry;
import eu.hurion.tadaah.springmvc.dto.TodoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    private TodoRegistry todoRegistry;

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    public @ResponseBody List<Todo> getToDoList() {
        return todoRegistry.getTodos();
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Todo getToDo(@PathVariable Long id) {
        return todoRegistry.getTodo(id);
    }

    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    public @ResponseBody Todo save(@RequestBody TodoDTO todo){
        return todoRegistry.save(todo);
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
    public void deleteToDo(@PathVariable Long id) {
    }

    public void setTodoRegistry(final TodoRegistry todoRegistry) {
        this.todoRegistry = todoRegistry;
    }
}
