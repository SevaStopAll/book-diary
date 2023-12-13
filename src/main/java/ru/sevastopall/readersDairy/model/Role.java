package ru.sevastopall.readersDairy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity(name = "roles")
@Data
public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

}
