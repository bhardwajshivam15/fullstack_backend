package com.example.demo.controller;
import com.example.demo.entities.Task;
import com.example.demo.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class MyController {
    @Autowired
    private TaskServices taskServices;

    @GetMapping
    public List<Task> getTasks(){
        return this.taskServices.getTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id){
        return taskServices.getTask(id)
                .map(task -> ResponseEntity.ok().body(task))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return this.taskServices.addTask(task);
    }

    @PutMapping
    public ResponseEntity<Task> updateTask(@RequestBody Task task){
        return ResponseEntity.ok(this.taskServices.updateTask(task));
    }

    @DeleteMapping("/{id}")
    public Task deleteTask(@PathVariable String id){
        return this.taskServices.deleteTask(Long.parseLong(id));
    }

}
