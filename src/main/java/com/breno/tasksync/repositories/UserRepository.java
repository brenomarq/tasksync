package com.breno.tasksync.repositories;

import com.breno.tasksync.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
