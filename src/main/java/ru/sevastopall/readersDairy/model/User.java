package ru.sevastopall.readersDairy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String password;

    @ManyToMany
    private Set<Role> roles;

    private LocalDateTime registrationDate;
}
