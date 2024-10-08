package com.example.demo.services;
import com.example.demo.entities.Task;
import java.util.List;
import java.util.Optional;

public interface TaskServices {
    public List<Task> getTasks();
    public Optional<Task> getTask(long taskId);
    public Task addTask(Task task);
    public Task updateTask(Task task);
    public Task deleteTask(long taskId);
}
