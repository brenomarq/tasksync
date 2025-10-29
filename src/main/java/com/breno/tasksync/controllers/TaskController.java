package com.breno.tasksync.controllers;

import com.breno.tasksync.dto.tasks.TaskRequestDTO;
import com.breno.tasksync.dto.tasks.TaskResponseDTO;
import com.breno.tasksync.entities.tasks.Task;
import com.breno.tasksync.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping()
    public ResponseEntity<List<TaskResponseDTO>> getAll() {
        List<TaskResponseDTO> tasks = taskRepository.findAll()
                .stream()
                .map(TaskResponseDTO::new)
                .toList();

        return ResponseEntity.ok(tasks);
    }


    @PostMapping()
    public ResponseEntity<TaskResponseDTO> saveTask(@RequestBody TaskRequestDTO data) {
        Task newTask = new Task(data);
        Task savedTask = taskRepository.save(newTask);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new TaskResponseDTO(savedTask));
    }

}
