package com.breno.tasksync.entities.users;

import com.breno.tasksync.dto.users.UserRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Table(name = "users")
@Entity(name = "users")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public User(UserRequestDTO user) {
        this.username = user.username();
        this.password = user.password();
        this.role = user.role();
    }
}
