package com.example.demo.dao;
import com.example.demo.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TaskDao extends JpaRepository<Task,Long> {}

