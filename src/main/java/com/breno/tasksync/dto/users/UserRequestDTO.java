package com.breno.tasksync.dto.users;

import com.breno.tasksync.entities.users.UserRole;

public record UserRequestDTO(String username, String password, UserRole role) {
}
