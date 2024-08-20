package com.example.demo.services;
import com.example.demo.dao.TaskDao;
import com.example.demo.entities.Task;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskServices {
    @Autowired
    private TaskDao taskDao;

    public TaskServiceImpl() {
    }

    @Override
    public List<Task> getTasks() {
        return taskDao.findAll();
    }

    @Override
    public Task getTask(long id){

        Optional<Task> optionalTask = taskDao.findById(id);
        Task task = null;
        if (optionalTask.isPresent()) {
            task = optionalTask.get();
        } else {
            throw new EntityNotFoundException("Task with id " + id + " not found");
        }
        return task;
    }


    @Override
    public Task addTask(Task task) {
        taskDao.save(task);
        return task;
    }

    @Override
    public Task updateTask(Task task) {
        taskDao.save(task);
        return task;
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
