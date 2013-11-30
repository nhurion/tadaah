package eu.hurion.tadaah.jpa.model;

import eu.hurion.tadaah.model.Todo;
import eu.hurion.tadaah.model.TodoStatus;

public class TodoJpa implements Todo {

    private final Long id;
    private final String title;
    private TodoStatus status;

    public TodoJpa(final Long id, final String title) {
        this.id = id;
        this.title = title;
        this.status = TodoStatus.TODO;
    }

    public String getTitle() {
        return title;
    }

    public TodoStatus getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }

    public void startProgress(){
        this.status = TodoStatus.IN_PROGRESS;
    }

    public void stopProgress(){
        this.status = TodoStatus.TODO;
    }

    public void finish(){
        this.status = TodoStatus.DONE;
    }

}
