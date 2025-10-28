package com.breno.tasksync.repositories;

import com.breno.tasksync.entities.tasks.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
