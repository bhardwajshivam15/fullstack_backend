package com.example.demo.services;

import com.example.demo.entities.Task;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaskServices {
    public List<Task> getTasks();
    public Task getTask(int taskId);
}
