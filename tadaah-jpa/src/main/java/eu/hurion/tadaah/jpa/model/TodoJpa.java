package eu.hurion.tadaah.jpa.model;

import eu.hurion.tadaah.model.Todo;
import eu.hurion.tadaah.model.TodoStatus;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class TodoJpa extends AbstractPersistable<Long> implements Todo {

    @Column(name = "title")
    private String title;
    @Column(name = "status")
    private TodoStatus status;

    public TodoJpa() {
    }

    public TodoJpa(final Long id, final String title) {
        this(id, title, TodoStatus.TODO);
    }

    public TodoJpa(final Long id, final String title, final TodoStatus status) {
        this.setId(id);
        this.title = title;
        this.status = status;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public TodoStatus getStatus() {
        return status;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setStatus(final TodoStatus status) {
        this.status = status;
    }

    public void startProgress() {
        this.status = TodoStatus.IN_PROGRESS;
    }

    public void stopProgress() {
        this.status = TodoStatus.TODO;
    }

    public void finish() {
        this.status = TodoStatus.DONE;
    }

}
