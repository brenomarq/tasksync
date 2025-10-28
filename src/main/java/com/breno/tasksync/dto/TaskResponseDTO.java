package com.breno.tasksync.dto;


import com.breno.tasksync.entities.tasks.Priority;
import com.breno.tasksync.entities.tasks.Task;

import java.util.Date;

public record TaskResponseDTO(
        Long id,
        String title,
        String description,
        Priority priority,
        Date createdAt
) {
    public TaskResponseDTO(Task task) {
        this(task.getId(), task.getTitle(), task.getDescription(), task.getPriority(), task.getCreatedAt());
    }
}
