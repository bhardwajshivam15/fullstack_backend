package com.example.demo.controller;


import com.example.demo.entities.Task;
import com.example.demo.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private TaskServices taskServices;
    @GetMapping("/home")
    public String Home(){
        return "Home";
    }

    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return this.taskServices.getTasks();
    }
}
