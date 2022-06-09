package me.chdm.springbootwithdockerdemo.service.api;

import me.chdm.springbootwithdockerdemo.model.User;
import me.chdm.springbootwithdockerdemo.model.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id) throws UserNotFoundException;

    void save(User user);
}
