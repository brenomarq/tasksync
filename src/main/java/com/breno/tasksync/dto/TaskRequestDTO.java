package com.breno.tasksync.dto;

import com.breno.tasksync.entities.tasks.Priority;

public record TaskRequestDTO(String title, String description, Priority priority) {
}
