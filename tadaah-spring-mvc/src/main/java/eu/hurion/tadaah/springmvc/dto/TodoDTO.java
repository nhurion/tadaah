package eu.hurion.tadaah.springmvc.dto;

import eu.hurion.tadaah.model.Todo;
import eu.hurion.tadaah.model.TodoStatus;

public class TodoDTO implements Todo  {
    private String title;
    private Long id;
    private TodoStatus status;

    public TodoDTO() {
    }

    public TodoDTO(Todo original) {
        this.title = original.getTitle();
        this.status = original.getStatus();
        this.id = original.getId();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(final TodoStatus status) {
        this.status = status;
    }
}
