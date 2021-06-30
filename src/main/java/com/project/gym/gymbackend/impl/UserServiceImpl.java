package com.project.gym.gymbackend.impl;

import com.project.gym.gymbackend.dao.UserDao;
import com.project.gym.gymbackend.model.User;
import com.project.gym.gymbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User editUser(User user, Long id) {
        User existUser =userDao.findById(id).orElse(null);
        existUser.setUsername(user.getUsername());
        existUser.setPassword(user.getPassword());
        existUser.setAdmin(user.isAdmin());
        return userDao.save(existUser);
    }

    @Override
    public User findUserById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
       Optional<User>users =userDao.findByUsername(username);
       return  users;
    }

    @Override
    public void deleteUser(long id) {
        User existUser = userDao.findById(id).orElse(null);
        userDao.delete(existUser);

    }
}
