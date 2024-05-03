package com.uri.progweb.userdep.services;

import com.uri.progweb.userdep.entities.User;
import com.uri.progweb.userdep.exceptions.UserNotFoundException;
import com.uri.progweb.userdep.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        List<User> result = repository.findAll();
        return result;
    }

    public User findById(Long id) {
        Optional<User> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }

        throw new UserNotFoundException();
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
