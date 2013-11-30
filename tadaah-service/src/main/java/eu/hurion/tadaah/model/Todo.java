package eu.hurion.tadaah.model;

public interface Todo {

    public String getTitle();

    public TodoStatus getStatus();

    public Long getId();

    public void startProgress();

    public void stopProgress();

    public void finish();

}
