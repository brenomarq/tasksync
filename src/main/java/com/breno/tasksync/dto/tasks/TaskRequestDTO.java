package com.breno.tasksync.dto.tasks;

import com.breno.tasksync.entities.tasks.Priority;

import java.util.UUID;

public record TaskRequestDTO(String title, String description, Priority priority, UUID userId) {
}
