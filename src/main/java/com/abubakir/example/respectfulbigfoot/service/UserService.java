package com.abubakir.example.respectfulbigfoot.service;

import com.abubakir.example.respectfulbigfoot.entities.User;
import com.abubakir.example.respectfulbigfoot.exception.NoEntityFoundException;
import com.abubakir.example.respectfulbigfoot.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(User user) {
        return userRepository.findById(user.getId()).map(this::createUser).orElseThrow(() -> new NoEntityFoundException("Could not find user"));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public boolean deleteUser(String id) {
        userRepository.delete(this.getUser(id));
        return this.getUser(id) == null;
    }
}
