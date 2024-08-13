package com.example.demo.services;
import com.example.demo.entities.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskServices {

    List<Task> list;

    public TaskServiceImpl() {
        this.list = new ArrayList<>();
        list.add(new Task("Second Task","This is my second task",12));

        list.add(new Task("First Task","This is my first task",45));
    }

    @Override
    public List<Task> getTasks() {
        return list;
    }

    public Task getTask(){

    }
}
