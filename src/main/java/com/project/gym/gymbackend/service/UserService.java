package com.project.gym.gymbackend.service;

import com.project.gym.gymbackend.model.User;

import java.util.Optional;

public interface UserService {
    User addUser(User user);

    User editUser(User user, Long id);

    User findUserById(Long id);
    Optional<User> findUserByUsername(String username);
    void deleteUser(long id);
}
