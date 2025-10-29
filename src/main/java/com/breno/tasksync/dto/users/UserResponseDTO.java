package com.breno.tasksync.dto.users;

import com.breno.tasksync.entities.tasks.Task;
import com.breno.tasksync.entities.users.User;
import com.breno.tasksync.entities.users.UserRole;

import java.util.Date;
import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String username,
        UserRole role,
        Date createdAt
) {
    public UserResponseDTO(User user) {
        this(user.getId(), user.getUsername(), user.getRole(), user.getCreatedAt());
    }
}
