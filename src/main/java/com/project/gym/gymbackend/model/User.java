package com.project.gym.gymbackend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    private boolean isAdmin;

    public User() {
        super();
    }

    public User(String username, String password, boolean isAdmin) {
        super();
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }
}
