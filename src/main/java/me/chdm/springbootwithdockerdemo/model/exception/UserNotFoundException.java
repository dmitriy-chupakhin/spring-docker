package me.chdm.springbootwithdockerdemo.model.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(Long id) {
        super(String.format("User with id = %d not found!", id));
    }
}
