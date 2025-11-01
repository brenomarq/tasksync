package com.breno.tasksync.controllers;

import com.breno.tasksync.dto.tasks.TaskRequestDTO;
import com.breno.tasksync.dto.tasks.TaskResponseDTO;
import com.breno.tasksync.entities.tasks.Task;
import com.breno.tasksync.repositories.TaskRepository;
import com.breno.tasksync.services.TaskService;
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
    private TaskService taskService;

//    @GetMapping()
//    public ResponseEntity<List<TaskResponseDTO>> getAll() {
//        List<TaskResponseDTO> tasks = taskRepository.findAll()
//                .stream()
//                .map(TaskResponseDTO::new)
//                .toList();
//
//        return ResponseEntity.ok(tasks);
//    }


    @PostMapping()
    public ResponseEntity<TaskResponseDTO> saveTask(@RequestBody TaskRequestDTO data) {
        Task savedTask = taskService.createTask(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(new TaskResponseDTO(savedTask));
    }

}
