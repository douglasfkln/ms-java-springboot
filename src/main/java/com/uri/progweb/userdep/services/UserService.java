package com.uri.progweb.userdep.services;

import com.uri.progweb.userdep.entities.User;
import com.uri.progweb.userdep.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        List<User> result = repository.findAll();
        return result;
    }

    public User findById(Long id) {
        User result = repository.findById(id).get();
        return result;
    }

    public User create(User user) {
        User result = repository.save(user);
        return result;
    }

    public void delete(Long id) {
        User user = findById(id);
        repository.delete(user);
    }

    public User update(Long id, User newUser) {
        User currentUser = repository.findById(id).get();
        currentUser.setName(newUser.getName());
        currentUser.setEmail(newUser.getEmail());
        currentUser.setDepartment(newUser.getDepartment());
        User user = repository.save(currentUser);
        return user;
    }
}
