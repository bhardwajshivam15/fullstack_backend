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
        list.add(new Task(12,"Second Task","This is my second task"));
        list.add(new Task(456,"First Task","This is my first task"));
    }

    @Override
    public List<Task> getTasks() {
        return list;
    }

    @Override
    public Task getTask(long taskId){
        Task ts = null;
        for(Task it:list){
            if(it.getId() == taskId){
                ts = it;
                break;
            }
        }
        return ts;
    }


    @Override
    public Task addTask(Task task) {
        list.add(task);
        return task;
    }

    @Override
    public Task updateTask(Task task) {
        for(Task ts:list){
            if(ts.getId() == task.getId()){
                ts.setTitle(task.getTitle());
                ts.setDescription(task.getDescription());
                break;
            }
        }
        return task;
    }

    @Override
    public Task deleteTask(long taskId) {
        int size = list.size();
        Task ts = getTask(taskId);
        for(int i=0;i<size;i++){
            if(list.get(i).getId() == taskId){
                list.remove(i);
                break;
            }
        }
        return ts;
    }
}
