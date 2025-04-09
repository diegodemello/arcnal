package com.arcnal.services;

import com.arcnal.entity.User;
import com.arcnal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user){
        return userRepository.save(user);
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
