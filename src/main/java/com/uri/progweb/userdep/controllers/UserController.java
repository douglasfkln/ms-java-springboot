package com.uri.progweb.userdep.controllers;

import com.uri.progweb.userdep.entities.User;
import com.uri.progweb.userdep.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value= "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> findAll() {
        List<User> result = repository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        User result = repository.findById(id).get();
        return result;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        User result = repository.save(user);
        return result;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        User user = repository.findById(id).get();
        repository.delete(user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(value = "/{id}")
    public User update(@PathVariable Long id,
                                         @RequestBody User newUser) {
        User currentUser = repository.findById(id).get();
        currentUser.setName(newUser.getName());
        currentUser.setEmail(newUser.getEmail());
        currentUser.setDepartment(newUser.getDepartment());
        User user = repository.save(currentUser);
        return user;
    }
}
