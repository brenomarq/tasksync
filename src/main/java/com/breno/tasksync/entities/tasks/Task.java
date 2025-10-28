package com.breno.tasksync.entities.tasks;

import jakarta.persistence.*;

import java.util.Date;

@Table(name = "tasks")
@Entity(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();
}
