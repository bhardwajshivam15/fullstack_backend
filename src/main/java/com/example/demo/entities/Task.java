package com.example.demo.entities;

public class Task {
    private long id;
    private String title;
    private String description;

    public Task(String title, String description, long id) {
        this.title = title;
        this.description = description;
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }
}
