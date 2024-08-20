package com.example.demo.controller;
import com.example.demo.entities.Task;
import com.example.demo.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private TaskServices taskServices;

    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return this.taskServices.getTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable String id){
        return this.taskServices.getTask(Long.parseLong(id));
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task){
        return this.taskServices.addTask(task);
    }

    @PutMapping("/tasks")
    public Task updateTask(@RequestBody Task task){
        return this.taskServices.updateTask(task);
    }

    @DeleteMapping("/tasks/{id}")
    public Task deleteTask(@PathVariable String id){
        return this.taskServices.deleteTask(Long.parseLong(id));
    }

}
