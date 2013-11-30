package eu.hurion.tadaah.springmvc.controller;

import com.codahale.metrics.annotation.Timed;
import eu.hurion.tadaah.model.Todo;
import eu.hurion.tadaah.service.TodoRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    private TodoRegistry todoRegistry;

    @Timed
    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    public @ResponseBody List<Todo> getToDoList() {
        return todoRegistry.getTodos();
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Todo getToDo(@PathVariable Long id) {
        return todoRegistry.getTodo(id);
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteToDo(@PathVariable Long id) {
    }

    public void setTodoRegistry(final TodoRegistry todoRegistry) {
        this.todoRegistry = todoRegistry;
    }
}
