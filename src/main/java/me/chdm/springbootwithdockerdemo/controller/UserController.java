package me.chdm.springbootwithdockerdemo.controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chdm.springbootwithdockerdemo.model.dto.UserDto;
import me.chdm.springbootwithdockerdemo.model.exception.UserNotFoundException;
import me.chdm.springbootwithdockerdemo.service.api.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService service;

    @GetMapping
    public List<UserDto> getUsers() {
        return service.findAll().stream().map(UserDto::new).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(new UserDto(service.findById(id)), HttpStatus.OK);
        } catch (UserNotFoundException ex) {
            log.error(ex.getMessage());
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping
    public void saveUser(@RequestBody UserDto dto) {
        service.save(dto.toUser());
    }

}
