package com.breno.tasksync.services;

import com.breno.tasksync.dto.tasks.TaskRequestDTO;
import com.breno.tasksync.entities.tasks.Task;
import com.breno.tasksync.entities.users.User;
import com.breno.tasksync.repositories.TaskRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Task createTask(TaskRequestDTO data) {
        User userReference = entityManager.getReference(User.class, data.userId());

        Task newTask = new Task(data);
        newTask.setUser(userReference);

        return taskRepository.save(newTask);
    }

}
