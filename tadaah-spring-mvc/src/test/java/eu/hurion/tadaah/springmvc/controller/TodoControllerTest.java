package eu.hurion.tadaah.springmvc.controller;

import eu.hurion.tadaah.model.Todo;
import eu.hurion.tadaah.model.TodoStatus;
import eu.hurion.tadaah.service.TodoRegistry;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("test-servlet-context.xml")
public class TodoControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private TodoRegistry todoRegistry;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void getAllTodos() throws Exception {
        Todo first = new Todo() {
            @Override
            public String getTitle() {
                return "title";
            }

            @Override
            public TodoStatus getStatus() {
                return TodoStatus.TODO;
            }

            @Override
            public Long getId() {
                return 1l;
            }

            @Override
            public void startProgress() {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void stopProgress() {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void finish() {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
        when(todoRegistry.getTodos()).thenReturn(Arrays.asList(first));
        this.mockMvc.perform(get("/todo").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].status", is("TODO")))
                .andExpect(jsonPath("$[0].title", is("title")));
    }
}
