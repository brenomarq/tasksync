package com.breno.tasksync.entities.tasks;

import com.breno.tasksync.dto.tasks.TaskRequestDTO;
import com.breno.tasksync.entities.users.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Table(name = "tasks")
@Entity(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Task(TaskRequestDTO task) {
        this.title = task.title();
        this.description = task.description();
        this.priority = task.priority();
    }
}
