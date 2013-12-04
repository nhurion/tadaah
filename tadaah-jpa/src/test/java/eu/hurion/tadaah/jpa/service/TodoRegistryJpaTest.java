package eu.hurion.tadaah.jpa.service;

import eu.hurion.tadaah.jpa.model.TodoJpa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/tadaah-jpa-beans.xml")
public class TodoRegistryJpaTest {

    @Autowired
    private TodoRegistrySpringData registry;

    @Test
    public void emptyDb() {
        assertEquals(0, registry.count());
    }

    @Test
    public void store() {
        TodoJpa todo = new TodoJpa(1l, "todo");
        registry.save(todo);
        assertEquals(1, registry.count());
    }
}
