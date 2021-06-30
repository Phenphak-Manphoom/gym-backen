package com.project.gym.gymbackend.controller;

import com.project.gym.gymbackend.model.User;
import com.project.gym.gymbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/editUser/{id}")
    User editUser(@RequestBody User user, @PathVariable long id) {
        return userService.editUser(user, id);
    }

    @GetMapping("/findUserById")
    User findUserById(@PathVariable long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/findUserByUsername/{username}")
    Optional<User> findUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    @DeleteMapping("/deleteUser/{id}")
    void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}
