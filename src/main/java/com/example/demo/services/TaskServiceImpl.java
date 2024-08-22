package com.example.demo.services;
import com.example.demo.dao.TaskDao;
import com.example.demo.entities.Task;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskServices {
    @Autowired
    private TaskDao taskDao;

    public TaskServiceImpl() {}

    @Override
    public List<Task> getTasks() {
        return taskDao.findAll();
    }

    @Override
    public Optional<Task> getTask(long id){
        Optional<Task> task = taskDao.findById(id);
        if (task.isPresent()) {
            return task;
        } else {
            throw new EntityNotFoundException("Task with id " + id + " not found");
        }
    }


    @Override
    public Task addTask(Task task) {
        taskDao.save(task);
        return task;
    }

    @Override
    public Task updateTask(Task task) {
        long id = task.getId();
        Task newtask = taskDao.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        newtask.setTitle(task.getTitle());
        newtask.setDescription(task.getDescription());
        newtask.setPriority(task.getPriority());
        newtask.setDueDate(task.getDueDate());
        return taskDao.save(newtask);
    }

    @Override
    public Task deleteTask(long id) {
        Optional<Task> optionalTask = taskDao.findById(id);
        Task task = null;
        if (optionalTask.isPresent()) {
            task = optionalTask.get();
        } else {
            throw new EntityNotFoundException("Task with id " + id + " not found");
        }
        taskDao.delete(task);
        return task;
    }
}
