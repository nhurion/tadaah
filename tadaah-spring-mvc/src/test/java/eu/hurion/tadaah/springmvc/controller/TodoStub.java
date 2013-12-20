package eu.hurion.tadaah.springmvc.controller;

import eu.hurion.tadaah.model.Todo;
import eu.hurion.tadaah.model.TodoStatus;

public class TodoStub implements Todo {

    private final String title;
    private final Long id;
    private TodoStatus status;

    public TodoStub(final String title, final Long id) {
        this.title = title;
        this.id = id;
        this.status = TodoStatus.TODO;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public TodoStatus getStatus() {
        return status;
    }

    @Override
    public Long getId() {
        return id;
    }

}
