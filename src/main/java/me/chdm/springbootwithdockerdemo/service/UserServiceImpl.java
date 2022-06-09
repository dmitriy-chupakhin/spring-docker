package me.chdm.springbootwithdockerdemo.service;

import lombok.AllArgsConstructor;
import me.chdm.springbootwithdockerdemo.model.User;
import me.chdm.springbootwithdockerdemo.model.exception.UserNotFoundException;
import me.chdm.springbootwithdockerdemo.model.repository.UserRepository;
import me.chdm.springbootwithdockerdemo.service.api.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Long id) throws UserNotFoundException {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }
}
