package eu.hurion.tadaah.springmvc.dto;

import eu.hurion.tadaah.model.Todo;
import eu.hurion.tadaah.model.TodoStatus;

public class TodoDTO implements Todo {
    private String title;
    private Long id;
    private TodoStatus status;

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    @Override
    public Long getId() {
        return id;
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

    public void setId(final Long id) {
        this.id = id;
    }

    @Override
    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(final TodoStatus status) {
        this.status = status;
    }
}
