package eu.hurion.tadaah.jpa.service;

import eu.hurion.tadaah.jpa.model.TodoJpa;
import eu.hurion.tadaah.model.Todo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class TodoRegistryJpaTest {

    @Autowired
    private TodoRegistryJpa registry;

    @Test
    public void bla(){
        TodoJpa todo = new TodoJpa(1l, "first todo");
        registry.save(todo);
        final List<Todo> todos = registry.getTodos();
        assertEquals(1, todos.size());
    }
}
